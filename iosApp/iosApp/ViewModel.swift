import SwiftUI
import shared

class ViewModel: ObservableObject {
    @Published var text = "Loading..."

    init() {
        Greeting().greet { greeting, error in
            DispatchQueue.main.async {
                if let gree = greeting {
                    self.text = gree
                } else {
                    self.text = error?.localizedDescription ?? "error"
                }
            }
        }
    }

}
