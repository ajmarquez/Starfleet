//
//  ProductsTableViewController.swift
//  GoodAsOldPhones
//
//  Created by Abelardo Marquez on 1/18/16.
//  Copyright © 2016 NinjaRobot. All rights reserved.
//

import UIKit

class ProductsTableViewController: UITableViewController {
    
    
    var product:[Product]?
    var product1 = Product()
    var product2 = Product()
    var product3 = Product()
    var product4 = Product()
    
    
    //MARK: TableView Protocol Methods
    override func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        if  let p = product {
            return p.count
        }
        
        return 0
    }
    
    override func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCellWithIdentifier("ProductCell", forIndexPath: indexPath)
        
        
        
        if let p = product?[indexPath.row] {
            
            cell.textLabel?.text = p.name
            if let i = p.cellImage {
                cell.imageView?.image = UIImage(named: i)
            }
        }
        
        return cell
    }
    
    //MARK: Tableview Methods
    
    override func viewDidLoad() {
        
        
        product1.name = "1907 Wall Set"
        product1.productImage = "phone-fullscreen1"
        product1.cellImage = "image-cell1"
        
        product2.name = "1921 Dial Phone"
        product2.productImage = "phone-fullscreen2"
        product2.cellImage = "image-cell2"
        
        product3.name = "1937 Desk Set"
        product3.productImage = "phone-fullscreen3"
        product3.cellImage = "image-cell3"
        
        product4.name = "1984 Motorola Portable"
        product4.productImage = "phone-fullscreen4"
        product4.cellImage = "image-cell4"
        
        product = [product1, product2, product3, product4]
        
    }
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        
        if segue.identifier == "ShowProduct" {
            
            let productVC = segue.destinationViewController as? ProductViewController
            
            guard let cell = sender as? UITableViewCell,
                let indexpath = tableView.indexPathForCell(cell) else {
                    return
            }
            
            productVC?.product = product?[indexpath.row]
            
        }
        
        
    }
    
}
