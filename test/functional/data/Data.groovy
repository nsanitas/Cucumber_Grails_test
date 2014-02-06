package data

import invoices.Invoice

class Data {    
	
	static def invoices = [        
		[amount: 12, merchant: "McDo"],
		[amount: 14, merchant: "Fischer"]
	]    
	
	static public def findByAmount(int amountToFind) {        
		invoices.find { invoice ->            
			invoice.amount == amountToFind        
		}    
	}
	
	static public def findByMerchant(String merchantToFind) {
		invoices.find { invoice ->
			invoice.merchant == merchantToFind
		}
	}
	
	static void clearInvoices () {        
		Invoice.findAll()*.delete (flush: true)    
	} 

}
