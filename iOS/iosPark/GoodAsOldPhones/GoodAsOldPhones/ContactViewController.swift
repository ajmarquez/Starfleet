//
//  ContactViewController.swift
//  GoodAsOldPhones
//
//  Created by Abelardo Marquez on 1/11/16.
//  Copyright © 2016 NinjaRobot. All rights reserved.
//

import UIKit

class ContactViewController: UIViewController {
    
    @IBOutlet weak var scrollView: UIScrollView!

    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        view.addSubview(scrollView);
    }
    
    override func viewWillLayoutSubviews() {
        super.viewWillLayoutSubviews()
        
        scrollView.contentSize = CGSizeMake(375, 800)
    }
    
    
}
