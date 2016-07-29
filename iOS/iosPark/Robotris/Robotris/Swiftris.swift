//
//  Swiftris.swift
//  Robotris
//
//  Created by Abelardo Marquez on 1/19/16.
//  Copyright © 2016 NinjaRobot. All rights reserved.
//

let NumColumns = 10
let NumRows = 20

let StartingColumn = 4
let StartingRow = 0

let PreviewColumn = 12
let PreviewRow = 1

let PointsPerLine = 10
let LevelThreshold = 1000

protocol SwiftrisDelegate{
    
    func gameDidEnd(swiftris: Swiftris)
    
    // Invoked after a new game has begun
    func gameDidBegin(swiftris: Swiftris)
    
    //Invoked when the falling shape has become part of the game board
    func gameShapeDidLand(swiftris: Swiftris)
    
    // Invoked when the falling shape has changed its location
    func gameShapeDidMove(swifttris: Swiftris)
    
    // Invoked when falling shape has changed its locations after being dropped
    func gameShapeDidDrop(swiftris: Swiftris)
    
    // Invoked when the game has reached a new level
    func gameDidLevelUp(swiftris: Swiftris)
    
}

class Swiftris {
    var blockArray:Array2D<Block>
    var nextShape:Shape?
    var fallingShape:Shape?
    var delegate:SwiftrisDelegate?
    
    var score = 0
    var level = 1
    
    init(){
        fallingShape = nil
        nextShape = nil
        blockArray = Array2D<Block>(columns: NumColumns, rows: NumRows)
    }
    
    func beginGame(){
        if (nextShape == nil){
            nextShape = Shape.random(PreviewColumn, startingRow: PreviewRow)
        }
        delegate?.gameDidBegin(self)
    }
    
    func newShape() -> (fallingShape:Shape?, nextShape:Shape?){
        fallingShape = nextShape
        nextShape = Shape.random(PreviewColumn, startingRow: PreviewRow)
        fallingShape?.moveTo(StartingColumn, row: StartingRow)
        
        // #1
        
        guard detectIllegalPlacement() == false else {
            nextShape = fallingShape
            nextShape!.moveTo(PreviewColumn, row: PreviewRow)
            endGame()
            return (nil, nil)
        }
        return (fallingShape, nextShape)
        
    }
    
    // #2
    func detectIllegalPlacement() -> Bool {
        guard let shape = fallingShape else {
            return false
        }
        for block in shape.blocks {
            if block.column < 0 || block.column >= NumColumns || block.row < 0 || block.row >= NumRows {
                return true
            } else if blockArray[block.column, block.row] != nil {
                return true
            }
        }
        return false
    }
    
    func settleShape() {
        guard let shape = fallingShape else {
            return
        }
        for block in shape.blocks {
            blockArray[block.column, block.row] = block
        }
        fallingShape = nil
        delegate?.gameShapeDidLand(self)
    }
    
    func detectTouch() -> Bool {
        guard let shape = fallingShape else {
            return false
        }
        for bottomblock in shape.bottomBlocks {
            if bottomblock.row == NumRows - 1 || blockArray[bottomblock.column, bottomblock.row + 1] != nil {
                return true
            }
            
        }
        return false
    }
    
    func endGame() {
        score = 0
        level = 1
        delegate?.gameDidEnd(self)
    }
    
    func removeCompletedLines() -> (linesRemoved: Array<Array<Block>>, fallenBlocks: Array<Array<Block>>) {
        var removedLines = Array<Array<Block>>()
        for var row = NumRows - 1; row > 0; row-- {
            var rowOfBlocks = Array<Block>()
            
            for column in 0..<NumColumns {
                guard let block = blockArray[column, row] else {
                    continue
                }
                rowOfBlocks.append(block)
            }
            if rowOfBlocks.count == NumColumns {
                removedLines.append(rowOfBlocks)
                for block in rowOfBlocks {
                    blockArray[block.column, block.row] = nil
                }
            }
            
        }
        
        
        if removedLines.count == 0 {
            return ([], [])
        }
        
        let pointsEarned = removedLines.count * PointsPerLine * level
        score += pointsEarned
        if score >= level * LevelThreshold {
            level += 1
            delegate?.gameDidLevelUp(self)
        }
        
        var fallenBlocks = Array<Array<Block>>()
        for column in 0..<NumColumns {
            var fallenBlocksArray = Array<Block>()
            
            for var row = removedLines[0][0].row - 1; row > 0; row-- {
                guard let block = blockArray[column, row] else {
                    continue
                }
                var newRow = row
                while (newRow < NumRows - 1 && blockArray[column, newRow + 1] ==  nil){
                    newRow++
                }
                block.row = newRow
                blockArray[column, row] = nil
                blockArray[column, newRow] = block
                fallenBlocksArray.append(block)
            }
            if fallenBlocksArray.count > 0 {
                fallenBlocks.append(fallenBlocksArray)
            }
        }
        return (removedLines, fallenBlocks)
    }
    
    
    func dropShape() {
        guard let shape = fallingShape else {
            return
        }
        while detectIllegalPlacement() == false {
            shape.lowerShapeByOneRow()
        }
        shape.raiseShapeByOneRow()
        delegate?.gameShapeDidDrop(self)
    }
    
    func letShapeFall() {
        guard let shape = fallingShape else {
            return
        }
        shape.lowerShapeByOneRow()
        if detectIllegalPlacement() {
            shape.raiseShapeByOneRow()
            if detectIllegalPlacement() {
                endGame()
            } else {
                settleShape()
            }
        } else {
            
            delegate?.gameShapeDidMove(self)
            if detectTouch() {
                settleShape()
            }
            
        }
    }
    
    func rotateShape() {
        guard let shape = fallingShape else {
            return
        }
        shape.rotateCLockwise()
        guard detectIllegalPlacement() == false else {
            shape.rotateCounterClockwise()
            return
        }
        delegate?.gameShapeDidMove(self)
    }
    
    func moveShapeLeft() {
        guard let shape = fallingShape else {
            return
        }
        shape.shiftLeftByOneColumn()
        guard detectIllegalPlacement() == false else {
            shape.shiftRightByOneCOlumn()
            return
        }
        delegate?.gameShapeDidMove(self)
    }
    
    func moveShapeRight() {
        guard let shape = fallingShape else {
            return
        }
        shape.shiftRightByOneCOlumn()
        guard detectIllegalPlacement() == false else {
            shape.shiftLeftByOneColumn()
            return
        }
        delegate?.gameShapeDidMove(self)
    }
    
    func removeAllBlocks() -> Array<Array<Block>> {
        var allBlocks = Array<Array<Block>>()
        for row in 0..<NumRows {
            var rowOfBlocks = Array<Block>()
            for column in 0..<NumColumns {
                guard let block = blockArray[column, row] else {
                    continue
                }
                rowOfBlocks.append(block)
                blockArray[column, row] = nil
            }
            allBlocks.append(rowOfBlocks)
        }
        return allBlocks
    }
    
    
}
