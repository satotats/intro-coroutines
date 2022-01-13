package tasks

import contributors.*
import kotlinx.coroutines.coroutineScope

suspend fun loadContributorsProgress(
    service: GitHubService,
    req: RequestData,
    updateResults: suspend (List<User>, completed: Boolean) -> Unit
) = coroutineScope {
    val repos = service
        .getOrgRepos(req.org)
        .also { logRepos(req, it) }
        .body() ?: listOf()

    repos.foldIndexed(listOf<User>()) { i, acc, repo ->
        (acc + service
            .getRepoContributors(req.org, repo.name)
            .also { logUsers(repo, it) }
            .bodyList()).aggregate()
            .apply { updateResults(this, i == repos.size) }
    }
}
