import SwiftUI
import shared

struct ContentView: View {
	 @ObservedObject private(set) var viewModel: ViewModel

	var body: some View {
		Text(viewModel.text)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView(viewModel: ViewModel())
	}
}
