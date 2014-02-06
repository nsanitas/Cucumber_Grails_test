package data

import invoices.Invoice

class Data {    
	
	static def invoices = [        
		[amount: 12.2, merchant: "McDo"]    
	]    
	
	static public def findByMerchant(String merchantToFind) {        
		invoices.find { invoice ->            
			invoice.merchant == merchantToFind        
		}    
	}    
	
	static void clearInvoices () {        
		Invoice.findAll()*.delete (flush: true)    
	} 

}
