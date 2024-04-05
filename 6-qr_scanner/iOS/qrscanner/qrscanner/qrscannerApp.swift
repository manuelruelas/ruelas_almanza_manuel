//
//  qrscannerApp.swift
//  qrscanner
//
//  Created by Mac mini on 04/04/24.
//

import SwiftUI
import SwiftData

@main
struct qrscannerApp: App {
    var sharedModelContainer: ModelContainer = {
        let schema = Schema([
            Scan.self,
        ])
        let modelConfiguration = ModelConfiguration(schema: schema, isStoredInMemoryOnly: false)

        do {
            return try ModelContainer(for: schema, configurations: [modelConfiguration])
        } catch {
            fatalError("Could not create ModelContainer: \(error)")
        }
    }()

    var body: some Scene {
        WindowGroup {
            ScanListView()
        }
        .modelContainer(sharedModelContainer)
    }
}
