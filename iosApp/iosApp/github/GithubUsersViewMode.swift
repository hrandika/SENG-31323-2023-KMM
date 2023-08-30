import Foundation
import shared

class GithubUsersViewModel: ObservableObject {
    @Published var githubUsers = [GithubUser]()

    private let repository: GithubRepository
    init(repository: GithubRepository) {
        self.repository = repository
    }
    
    func fetchUsers() {
        repository.fetchUsers { githubUsers, _ in
            if let users = githubUsers {
                self.githubUsers = users
            }
        }
    }
}
