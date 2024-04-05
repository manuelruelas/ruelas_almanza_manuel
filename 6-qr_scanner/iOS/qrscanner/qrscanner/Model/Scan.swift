//
//  Scan.swift
//  qrscanner
//
//  Created by Mac mini on 04/04/24.
//
import Foundation
import SwiftData

@Model
class Scan{
    
    var date:Date
    var data:String
    
    init(date: Date, data:String){
        self.date = date
        self.data = data
    }
    
}
