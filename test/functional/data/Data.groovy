package data

import invoices.Invoice

class Data {    
	
	static def invoices = [        
		[amount: 12, merchant: "McDo"],
		[amount: 14, merchant: "McDo"]
	]    
	
	static public def findByAmount(int amountToFind) {        
		invoices.find { invoice ->            
			invoice.amount == amountToFind        
		}    
	}    
	
	static void clearInvoices () {        
		Invoice.findAll()*.delete (flush: true)    
	} 

}
