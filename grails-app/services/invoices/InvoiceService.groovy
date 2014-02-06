package invoices

import invoices.Invoice;

class InvoiceService {    
	
	Invoice add (Map params) {        
		def newInvoice = new Invoice (params)        
		newInvoice.save ()        
		newInvoice    
	}
	
	List<Invoice> all () {        
		Invoice.findAll ()    
	}
}