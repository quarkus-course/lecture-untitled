package com.example;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class GetOrdersResponse extends AdminServiceResponse {

	// phpdoc attributes below takes its info from admin service api Order structure
    /** Date when order status was changed, e.g when order was delivered. */
    public String changedDate;
    /** Id that identifies a client in sveawebpay system */
    public String clientId;
    /** Order number from client's ordersystem */
    public String clientOrderId;
    /** Date when order was first created. */
    public String createdDate;

    /** Tells if credit decision is accepted or not */
    public Boolean creditReportStatusAccepted;
    /** Date of order credit decision. */
    public String creditReportStatusCreationDate;

    /** Country currency */
    public String currency;

    /** @var CompanyCustomer|IndividualCustomer $customer -- customer identity as associated with the order by Svea, also Shipping address. */
    //public XXX customer;

    /** Customer id that is created by SveaWebPay system. */
    public String customerId;
    /** Customer Reference. (Gets printed on the invoice.)*/
    public String customerReference;
    public Boolean isPossibleToAdminister;
    /** Tells if order can be cancelled or not */
    public Boolean isPossibleToCancel;
    /** Text on order created by client */
    public String notes;
    /** one of {Created,PartiallyDelivered,Delivered,Cancelled} */
    public String orderDeliveryStatus; // TODO change to enum!

    /** @var Svea\OrderRow[] $numberedOrderRows  array of OrderRow objects, note that invoice and payment plan order rows name attribute will be null */
    //public YYY numberedOrderRows;

    /** one of {Created,Pending,Active,Denied,Error}*/
    public String orderStatus; // TODO change to enum!
    public String getChangedDate() {
		return changedDate;
	}

	public void setChangedDate(String changedDate) {
		this.changedDate = changedDate;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientOrderId() {
		return clientOrderId;
	}

	public void setClientOrderId(String clientOrderId) {
		this.clientOrderId = clientOrderId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getCreditReportStatusAccepted() {
		return creditReportStatusAccepted;
	}

	public void setCreditReportStatusAccepted(Boolean creditReportStatusAccepted) {
		this.creditReportStatusAccepted = creditReportStatusAccepted;
	}

	public String getCreditReportStatusCreationDate() {
		return creditReportStatusCreationDate;
	}

	public void setCreditReportStatusCreationDate(
			String creditReportStatusCreationDate) {
		this.creditReportStatusCreationDate = creditReportStatusCreationDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerReference() {
		return customerReference;
	}

	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}

	public Boolean getIsPossibleToAdminister() {
		return isPossibleToAdminister;
	}

	public void setIsPossibleToAdminister(Boolean isPossibleToAdminister) {
		this.isPossibleToAdminister = isPossibleToAdminister;
	}

	public Boolean getIsPossibleToCancel() {
		return isPossibleToCancel;
	}

	public void setIsPossibleToCancel(Boolean isPossibleToCancel) {
		this.isPossibleToCancel = isPossibleToCancel;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getOrderDeliveryStatus() {
		return orderDeliveryStatus;
	}

	public void setOrderDeliveryStatus(String orderDeliveryStatus) {
		this.orderDeliveryStatus = orderDeliveryStatus;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getPaymentPlanDetailsContractLengthMonths() {
		return paymentPlanDetailsContractLengthMonths;
	}

	public void setPaymentPlanDetailsContractLengthMonths(
			String paymentPlanDetailsContractLengthMonths) {
		this.paymentPlanDetailsContractLengthMonths = paymentPlanDetailsContractLengthMonths;
	}

	public String getPaymentPlanDetailsContractNumber() {
		return paymentPlanDetailsContractNumber;
	}

	public void setPaymentPlanDetailsContractNumber(
			String paymentPlanDetailsContractNumber) {
		this.paymentPlanDetailsContractNumber = paymentPlanDetailsContractNumber;
	}

	public String getPendingReasonsPendingType() {
		return pendingReasonsPendingType;
	}

	public void setPendingReasonsPendingType(String pendingReasonsPendingType) {
		this.pendingReasonsPendingType = pendingReasonsPendingType;
	}

	public String getPendingReasonsCreatedDate() {
		return pendingReasonsCreatedDate;
	}

	public void setPendingReasonsCreatedDate(String pendingReasonsCreatedDate) {
		this.pendingReasonsCreatedDate = pendingReasonsCreatedDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Boolean getSveaWillBuy() {
		return sveaWillBuy;
	}

	public void setSveaWillBuy(Boolean sveaWillBuy) {
		this.sveaWillBuy = sveaWillBuy;
	}

	/** @var one of {Invoice,PaymentPlan} */
    public String orderType; // TODO change to enum!

    public String paymentPlanDetailsContractLengthMonths;
    /** Contract number of a specific contract. */
    public String paymentPlanDetailsContractNumber;

    /** one of {SMSOnHighAmount,UseOfDeliveryAddress} */
    public String pendingReasonsPendingType;  // TODO change to enum!
    public String pendingReasonsCreatedDate;

    /** Unique Id for the created order. Used for any further order webservice requests. */
    public String orderId;
    /** Describes whether SveaWebPay will buy the order or just administrate it */
    public Boolean sveaWillBuy;	

    public GetOrdersResponse(NodeList xmlResponse) {		
    	super( xmlResponse );
    	setGetOrdersResponseAttributes(xmlResponse);
	}
    
	//<s:Envelope xmlns:s="http://schemas.xmlsoap.org/soap/envelope/">
	//	<s:Body>
	//		<GetOrdersResponse xmlns="http://tempuri.org/">
	//			<GetOrdersResult
	//				xmlns:a="http://schemas.datacontract.org/2004/07/DataObjects.Admin.Service"
	//				xmlns:i="http://www.w3.org/2001/XMLSchema-instance">
	//				<a:ErrorMessage i:nil="true" />
	//				<a:ResultCode>0</a:ResultCode>
	//				<a:Orders>
	//					<a:Order>
	//						<a:ChangedDate i:nil="true" />
	//						<a:ClientId>79021</a:ClientId>
	//						<a:ClientOrderId>449</a:ClientOrderId>
	//						<a:CreatedDate>2014-05-19T16:04:54.787</a:CreatedDate>
	//						<a:CreditReportStatus>
	//							<a:Accepted>true</a:Accepted>
	//							<a:CreationDate>2014-05-19T16:04:54.893</a:CreationDate>
	//						</a:CreditReportStatus>
	//						<a:Currency>SEK</a:Currency>
	//						<a:Customer
	//							xmlns:b="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">
	//							<b:CoAddress>c/o Eriksson, Erik</b:CoAddress>
	//							<b:CompanyIdentity i:nil="true" />
	//							<b:CountryCode>SE</b:CountryCode>
	//							<b:CustomerType>Individual</b:CustomerType>
	//							<b:Email>daniel@colourpicture.se</b:Email>
	//							<b:FullName>Persson, Tess T</b:FullName>
	//							<b:HouseNumber i:nil="true" />
	//							<b:IndividualIdentity>
	//								<b:BirthDate i:nil="true" />
	//								<b:FirstName i:nil="true" />
	//								<b:Initials i:nil="true" />
	//								<b:LastName i:nil="true" />
	//							</b:IndividualIdentity>
	//							<b:Locality>Stan</b:Locality>
	//							<b:NationalIdNumber>194605092222</b:NationalIdNumber>
	//							<b:PhoneNumber>08-11111111</b:PhoneNumber>
	//							<b:PublicKey i:nil="true" />
	//							<b:Street>Testgatan 1</b:Street>
	//							<b:ZipCode>99999</b:ZipCode>
	//						</a:Customer>
	//						<a:CustomerId>1000117</a:CustomerId>
	//						<a:CustomerReference />
	//						<a:DeliveryAddress i:nil="true"
	//							xmlns:b="http://schemas.datacontract.org/2004/07/DataObjects.Webservice" />
	//						<a:IsPossibleToAdminister>false</a:IsPossibleToAdminister>
	//						<a:IsPossibleToCancel>true</a:IsPossibleToCancel>
	//						<a:Notes i:nil="true" />
	//						<a:OrderDeliveryStatus>Created</a:OrderDeliveryStatus>
	//						<a:OrderRows>
	//							<a:NumberedOrderRow>
	//								<ArticleNumber i:nil="true"
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice" />
	//								<Description
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">Dyr produkt 25%</Description>
	//								<DiscountPercent
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">0.00</DiscountPercent>
	//								<NumberOfUnits
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">2.00</NumberOfUnits>
	//								<PriceIncludingVat
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">false</PriceIncludingVat>
	//								<PricePerUnit
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">2000.00</PricePerUnit>
	//								<Unit
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice" />
	//								<VatPercent
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">25.00</VatPercent>
	//								<a:CreditInvoiceId i:nil="true" />
	//								<a:InvoiceId i:nil="true" />
	//								<a:RowNumber>1</a:RowNumber>
	//								<a:Status>NotDelivered</a:Status>
	//							</a:NumberedOrderRow>
	//							<a:NumberedOrderRow>
	//								<ArticleNumber i:nil="true"
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice" />
	//								<Description
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">Testprodukt 1kr 25%</Description>
	//								<DiscountPercent
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">0.00</DiscountPercent>
	//								<NumberOfUnits
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">1.00</NumberOfUnits>
	//								<PriceIncludingVat
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">false</PriceIncludingVat>
	//								<PricePerUnit
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">1.00</PricePerUnit>
	//								<Unit
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice" />
	//								<VatPercent
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">25.00</VatPercent>
	//								<a:CreditInvoiceId i:nil="true" />
	//								<a:InvoiceId i:nil="true" />
	//								<a:RowNumber>2</a:RowNumber>
	//								<a:Status>NotDelivered</a:Status>
	//							</a:NumberedOrderRow>
	//							<a:NumberedOrderRow>
	//								<ArticleNumber i:nil="true"
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice" />
	//								<Description
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">Fastpris (Fast fraktpris)</Description>
	//								<DiscountPercent
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">0.00</DiscountPercent>
	//								<NumberOfUnits
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">1.00</NumberOfUnits>
	//								<PriceIncludingVat
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">false</PriceIncludingVat>
	//								<PricePerUnit
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">4.00</PricePerUnit>
	//								<Unit i:nil="true"
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice" />
	//								<VatPercent
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">25.00</VatPercent>
	//								<a:CreditInvoiceId i:nil="true" />
	//								<a:InvoiceId i:nil="true" />
	//								<a:RowNumber>3</a:RowNumber>
	//								<a:Status>NotDelivered</a:Status>
	//							</a:NumberedOrderRow>
	//							<a:NumberedOrderRow>
	//								<ArticleNumber
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice" />
	//								<Description
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">Svea Fakturaavgift:: 20.00kr (SE)</Description>
	//								<DiscountPercent
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">0.00</DiscountPercent>
	//								<NumberOfUnits
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">1.00</NumberOfUnits>
	//								<PriceIncludingVat
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">false</PriceIncludingVat>
	//								<PricePerUnit
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">20.00</PricePerUnit>
	//								<Unit i:nil="true"
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice" />
	//								<VatPercent
	//									xmlns="http://schemas.datacontract.org/2004/07/DataObjects.Webservice">0.00</VatPercent>
	//								<a:CreditInvoiceId i:nil="true" />
	//								<a:InvoiceId i:nil="true" />
	//								<a:RowNumber>4</a:RowNumber>
	//								<a:Status>NotDelivered</a:Status>
	//							</a:NumberedOrderRow>
	//						</a:OrderRows>
	//						<a:OrderStatus>Active</a:OrderStatus>
	//						<a:OrderType>Invoice</a:OrderType>
	//						<a:PaymentPlanDetails i:nil="true" />
	//						<a:PendingReasons />
	//						<a:SveaOrderId>348629</a:SveaOrderId>
	//						<a:SveaWillBuy>true</a:SveaWillBuy>
	//					</a:Order>
	//				</a:Orders>
	//			</GetOrdersResult>
	//		</GetOrdersResponse>
	//	</s:Body>
	//</s:Envelope>
    

	private void setGetOrdersResponseAttributes(NodeList xmlResponse) {
		int size = xmlResponse.getLength();

		for (int i = 0; i < size; i++) {
			Element node = (Element) xmlResponse.item(i);
			String nodeName = node.getNodeName();
			// System.out.println(nodeName);		
			
			switch (nodeName) {
			case "a:ChangedDate":				
				this.setChangedDate(node.getTextContent());
				break;
			case "a:ClientId":
				this.setClientId(node.getTextContent());
				break;
			case "a:ClientOrderId":
				this.setClientOrderId(node.getTextContent());
				break;
			case "a:CreatedDate":
				this.setCreatedDate(node.getTextContent());		// TODO parse date format?
				break;				
			case "a:CreditReportStatus":
				this.setCreditReportStatusAccepted(Boolean.valueOf(node.getChildNodes().item(0).getTextContent()));
				this.setCreditReportStatusCreationDate(node.getChildNodes().item(1).getTextContent()); // TODO parse date format?				
				break;	
			default:
				// TODO throw exception -- unrecognised response
			}
		}
	}


	
}
