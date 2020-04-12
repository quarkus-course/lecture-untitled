package com.example;

import javax.xml.soap.*;

import org.w3c.dom.NodeList;

public class SOAPClientSAAJ {

    public static void main(String args[]) throws Exception {
        // Create SOAP Connection
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        // Send SOAP Message to SOAP Server
        String url = "https://partnerweb.sveaekonomi.se/WebPayAdminService_test/AdminService.svc/backward";
    	SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);
        
        // print SOAP Response
		System.out.print("Response SOAP Message:");
		soapResponse.writeTo(System.out);
        
        soapConnection.close();
        
        GetOrdersResponse response = parseResponse(soapResponse, "GetOrdersResponse");
        System.out.println(response.isOrderAccepted());
        System.out.println(response.getResultCode());
        System.out.println(response.getErrorMessage());

        System.out.println(response.getChangedDate());
        System.out.println(response.getClientId());
        System.out.println(response.getClientOrderId());
        System.out.println(response.getCreatedDate());
        System.out.println(response.getCreditReportStatusAccepted());
        System.out.println(response.getCreditReportStatusCreationDate());
    }


    private static GetOrdersResponse parseResponse(SOAPMessage soapMessage, String responseHeader) throws SOAPException {  	        
    	NodeList nodeList = soapMessage.getSOAPPart().getEnvelope().getBody().getElementsByTagName("*");
    	return new GetOrdersResponse( nodeList );
	}

	/**
     * @return
     * @throws Exception
     */
    private static SOAPMessage createSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
    
		//<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tem="http://tempuri.org/" xmlns:dat="http://schemas.datacontract.org/2004/07/DataObjects.Admin.Service">
		//   <soapenv:Header/>
		//   <soapenv:Body>
		//      <tem:GetOrders>
		//         <!--Optional:-->
		//         <tem:request>
		//            <dat:Authentication>
		//               <dat:Password>sverigetest</dat:Password>
		//               <dat:Username>sverigetest</dat:Username>
		//            </dat:Authentication>
		//            <dat:OrdersToRetrieve>
		//               <dat:GetOrderInformation>
		//                  <dat:ClientId>79021</dat:ClientId>
		//                  <dat:OrderType>Invoice</dat:OrderType>
		//                  <dat:SveaOrderId>348629</dat:SveaOrderId>
		//               </dat:GetOrderInformation>
		//            </dat:OrdersToRetrieve>
		//         </tem:request>
		//      </tem:GetOrders>
		//   </soapenv:Body>
		//</soapenv:Envelope>    	    
	                	
        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
	    envelope.addNamespaceDeclaration("dat", "http://schemas.datacontract.org/2004/07/DataObjects.Admin.Service");
	    envelope.addNamespaceDeclaration("tem", "http://tempuri.org/");	    
        
	    // SOAP Body
	    SOAPBody start = envelope.getBody();
	    SOAPElement soapBody = start.addChildElement("GetOrders", "tem");
		    SOAPElement soapBodyElem = soapBody.addChildElement("request", "tem");
		    	SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("Authentication", "dat");
		    		SOAPElement soapBodyElem2 = soapBodyElem1.addChildElement("Password", "dat");
		    			soapBodyElem2.addTextNode("sverigetest");
		    		SOAPElement soapBodyElem3 = soapBodyElem1.addChildElement("Username", "dat");
		    			soapBodyElem3.addTextNode("sverigetest");
	    		
		    		SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("OrdersToRetrieve", "dat");
		    			SOAPElement soapBodyElem5 = soapBodyElem4.addChildElement("GetOrderInformation", "dat");
		    				SOAPElement soapBodyElem6 = soapBodyElem5.addChildElement("ClientId", "dat");
						    	soapBodyElem6.addTextNode("79021");
						    SOAPElement soapBodyElem7 = soapBodyElem5.addChildElement("OrderType", "dat");
						    	soapBodyElem7.addTextNode("Invoice");
						    SOAPElement soapBodyElem8 = soapBodyElem5.addChildElement("SveaOrderId", "dat");
						    	soapBodyElem8.addTextNode("348629");

						    	
        String soapActionPrefix = "http://tempuri.org/IAdminService/";
						    	
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapActionPrefix + "GetOrders");
					   
        soapMessage.saveChanges();

        /* Print the request message */
		System.out.print("Request SOAP Message:");
		soapMessage.writeTo(System.out);
		System.out.println();

        return soapMessage;
    }

}