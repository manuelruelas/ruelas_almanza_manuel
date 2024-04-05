//
//  ContentView.swift
//  qrscanner
//
//  Created by Mac mini on 04/04/24.
//

import SwiftUI
import SwiftData
import CodeScanner


struct ScanListView: View {
    @Environment(\.modelContext) var modelContext
    @State private var viewModel: ScansListViewModel
    
    
    init() {
        self.viewModel = ScansListViewModel()
    }

    var body: some View {
        NavigationView {
            Group{
                List(viewModel.scans){scan in
                    HStack{
                        Image(systemName: "qrcode")
                        VStack(alignment: .leading){
                            Text(scan.data).bold()
                            Text(formatDate(scan.date)).fontWeight(.light).foregroundStyle(.gray)
                        }
                    }
                }
                .toolbar {
                    ToolbarItem {
                        Button(action: showScannerView) {
                            Label("Scan Code", systemImage: "qrcode.viewfinder")
                        }
                    }
                }.navigationTitle("Scans")
            }.overlay {
                if(viewModel.scans.isEmpty){
                VStack{
                        Text("Scans not found!")
                        Text("Tap the icon to start new scan")
                    }
                    
                }
                
            }
            
        }.onAppear{
            viewModel.modelContext = modelContext
            viewModel.fetchScans()
        }.sheet(isPresented: $viewModel.isShowingScanner, content: {
            CodeScannerView(codeTypes:[.qr], simulatedData: "www.google.com",completion: handleScan)
        })
    }
    
    
    /// If Scan is [.success] save the scanned data
    private func handleScan(result: Result<ScanResult, ScanError>){
        switch result {
            case .success(let result):
            let scanResult = result.string.components(separatedBy: "\n")
                if let scannedData = scanResult.first {
                    viewModel.saveScan(scannedData: scannedData)
                }
                viewModel.isShowingScanner = false
            case .failure(let error):
                print("Scanning failed: \(error.localizedDescription)")
        }
    }

    private func showScannerView() {
        viewModel.isShowingScanner=true
    }
    
    func formatDate(_ date: Date) -> String {
            let dateFormatter = DateFormatter()
            dateFormatter.dateStyle = .short
            dateFormatter.timeStyle = .short
            return dateFormatter.string(from: date)
        }

    
}


#Preview {
    ScanListView().modelContainer(for: Scan.self,inMemory: true)
}
