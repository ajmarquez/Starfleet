//
//  Array2D.swift
//  Robotris
//
//  Created by Abelardo Marquez on 1/19/16.
//  Copyright © 2016 NinjaRobot. All rights reserved.
//

class Array2D<T> {
    let columns: Int
    let rows: Int
    
    var array: Array<T?>
    
    init(columns: Int, rows: Int){
        self.columns = columns
        self.rows = rows
        
        array = Array<T?>(count: rows * columns, repeatedValue: nil)
        
    }
    
    subscript(column: Int, row: Int) -> T? {
        get{
            return array[(row * columns) + column]
        }
        set(newValue){
            array[(row * column) + column] = newValue
        }
    }
}

