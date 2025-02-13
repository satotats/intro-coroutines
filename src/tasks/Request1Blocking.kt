package tasks

import contributors.GitHubService
import contributors.RequestData
import contributors.User
import retrofit2.Response

fun loadContributorsBlocking(service: GitHubService, req: RequestData): List<User> {
//    val repos = service
//        .getOrgReposCall(req.org)
//        .execute() // Executes request and blocks the current thread
//        .also { logRepos(req, it) }
//        .body() ?: listOf()
//
//    return repos.flatMap { repo ->
//        service
//            .getRepoContributorsCall(req.org, repo.name)
//            .execute() // Executes request and blocks the current thread
//            .also { logUsers(repo, it) }
//            .bodyList()
//    }.aggregate()
    return listOf()
}

fun <T> Response<List<T>>.bodyList(): List<T> {
    return body() ?: listOf()
}