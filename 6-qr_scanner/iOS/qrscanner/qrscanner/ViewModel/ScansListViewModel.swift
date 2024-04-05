//
//  ScansList.swift
//  qrscanner
//
//  Created by Mac mini on 05/04/24.
//

import SwiftUI
import SwiftData

@Observable
class ScansListViewModel: ObservableObject {
    var modelContext: ModelContext? = nil
    var scans = [Scan]()
    var isShowingScanner = false
    
    func fetchScans(){
        do{
            let descriptor = FetchDescriptor<Scan>(sortBy: [SortDescriptor(\.date)])
            scans = try modelContext?.fetch(descriptor) ?? []
        }catch{
            print("Fetch failed")
        }
    }
    
    func saveScan(scannedData:String){
        let scan = Scan(date: Date(), data: scannedData)
        modelContext?.insert(scan)
        try? modelContext?.save()
        fetchScans()
    }
}
