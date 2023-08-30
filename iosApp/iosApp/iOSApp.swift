import SwiftUI
import shared

@main
struct iOSApp: App {
    let vm = GithubUsersViewModel(repository: GithubRepository())
    
	var body: some Scene {
		WindowGroup {
//			ContentView(viewModel: ViewModel())
            GithubUsersView(vm:vm)
		}
	}
}
