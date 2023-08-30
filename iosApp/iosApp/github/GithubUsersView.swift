import shared
import SwiftUI

struct GithubUsersView: View {
    @ObservedObject private(set) var vm: GithubUsersViewModel

    var body: some View {
        List(vm.githubUsers, id: \.login) { user in
            HStack {
                if #available(iOS 15.0, *) {
                    AsyncImage(url: URL(string: user.avatarUrl)) { image in
                        image.resizable()
                    } placeholder: {
                        ProgressView()
                    }
                    .frame(width: 50, height: 50)
                } else {
                    Rectangle().frame(width: 50, height: 50)
                }

                VStack(alignment: .leading) {
                    Text(user.login).font(Font.title)
                    Text(user.nodeId).font(Font.caption)
                }
            }
        }.onAppear {
            vm.fetchUsers()
        }
    }
}
