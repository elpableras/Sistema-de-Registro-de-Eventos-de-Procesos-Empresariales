
/**
 * ServicioStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.5  Built on : May 28, 2011 (08:30:56 CEST)
 */
        package com.ws.servidor;

        

        /*
        *  ServicioStub java implementation
        */

        
        public class ServicioStub extends org.apache.axis2.client.Stub
        {
        protected org.apache.axis2.description.AxisOperation[] _operations;

        //hashmaps to keep the fault mapping
        private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
        private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
        private java.util.HashMap faultMessageMap = new java.util.HashMap();

        private static int counter = 0;

        private static synchronized java.lang.String getUniqueSuffix(){
            // reset the counter if it is greater than 99999
            if (counter > 99999){
                counter = 0;
            }
            counter = counter + 1; 
            return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
        }

    
    private void populateAxisService() throws org.apache.axis2.AxisFault {

     //creating the Service with a unique name
     _service = new org.apache.axis2.description.AxisService("Servicio" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[2];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://servidor.ws.com", "infoRegistro"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><wsp:ExactlyOne><wsp:All><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:SecureConversationToken sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireDerivedKeys /><sp:BootstrapPolicy><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/Never\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /><sp:RequireDerivedKeys /></wsp:Policy></sp:X509Token></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:EndorsingSupportingTokens xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /></wsp:Policy></sp:X509Token></wsp:Policy></sp:EndorsingSupportingTokens><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /><sp:RequireSignatureConfirmation /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10></wsp:Policy></sp:BootstrapPolicy></wsp:Policy></sp:SecureConversationToken></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:SecureConversationToken sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireDerivedKeys /><sp:BootstrapPolicy><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/Never\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /><sp:RequireDerivedKeys /></wsp:Policy></sp:X509Token></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:EndorsingSupportingTokens xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /></wsp:Policy></sp:X509Token></wsp:Policy></sp:EndorsingSupportingTokens><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /><sp:RequireSignatureConfirmation /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10></wsp:Policy></sp:BootstrapPolicy></wsp:Policy></sp:SecureConversationToken></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><wsp:ExactlyOne><wsp:All><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:SecureConversationToken sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireDerivedKeys /><sp:BootstrapPolicy><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/Never\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /><sp:RequireDerivedKeys /></wsp:Policy></sp:X509Token></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:EndorsingSupportingTokens xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /></wsp:Policy></sp:X509Token></wsp:Policy></sp:EndorsingSupportingTokens><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /><sp:RequireSignatureConfirmation /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10></wsp:Policy></sp:BootstrapPolicy></wsp:Policy></sp:SecureConversationToken></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:SecureConversationToken sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireDerivedKeys /><sp:BootstrapPolicy><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/Never\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /><sp:RequireDerivedKeys /></wsp:Policy></sp:X509Token></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:EndorsingSupportingTokens xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /></wsp:Policy></sp:X509Token></wsp:Policy></sp:EndorsingSupportingTokens><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /><sp:RequireSignatureConfirmation /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10></wsp:Policy></sp:BootstrapPolicy></wsp:Policy></sp:SecureConversationToken></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://servidor.ws.com", "info"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><wsp:ExactlyOne><wsp:All><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:SecureConversationToken sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireDerivedKeys /><sp:BootstrapPolicy><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/Never\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /><sp:RequireDerivedKeys /></wsp:Policy></sp:X509Token></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:EndorsingSupportingTokens xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /></wsp:Policy></sp:X509Token></wsp:Policy></sp:EndorsingSupportingTokens><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /><sp:RequireSignatureConfirmation /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10></wsp:Policy></sp:BootstrapPolicy></wsp:Policy></sp:SecureConversationToken></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:SecureConversationToken sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireDerivedKeys /><sp:BootstrapPolicy><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/Never\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /><sp:RequireDerivedKeys /></wsp:Policy></sp:X509Token></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:EndorsingSupportingTokens xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /></wsp:Policy></sp:X509Token></wsp:Policy></sp:EndorsingSupportingTokens><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /><sp:RequireSignatureConfirmation /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10></wsp:Policy></sp:BootstrapPolicy></wsp:Policy></sp:SecureConversationToken></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><wsp:ExactlyOne><wsp:All><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:SecureConversationToken sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireDerivedKeys /><sp:BootstrapPolicy><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/Never\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /><sp:RequireDerivedKeys /></wsp:Policy></sp:X509Token></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:EndorsingSupportingTokens xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /></wsp:Policy></sp:X509Token></wsp:Policy></sp:EndorsingSupportingTokens><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /><sp:RequireSignatureConfirmation /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10></wsp:Policy></sp:BootstrapPolicy></wsp:Policy></sp:SecureConversationToken></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:SecureConversationToken sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireDerivedKeys /><sp:BootstrapPolicy><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts><sp:SymmetricBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:ProtectionToken><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/Never\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /><sp:RequireDerivedKeys /></wsp:Policy></sp:X509Token></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:EndorsingSupportingTokens xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:X509Token sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient\"><wsp:Policy><sp:RequireThumbprintReference /><sp:WssX509V3Token10 /></wsp:Policy></sp:X509Token></wsp:Policy></sp:EndorsingSupportingTokens><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /><sp:RequireSignatureConfirmation /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10></wsp:Policy></sp:BootstrapPolicy></wsp:Policy></sp:SecureConversationToken></wsp:Policy></sp:ProtectionToken><sp:AlgorithmSuite xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:Basic128Rsa15 /></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy><sp:Strict /></wsp:Policy></sp:Layout><sp:IncludeTimestamp /><sp:EncryptSignature /><sp:OnlySignEntireHeadersAndBody /></wsp:Policy></sp:SymmetricBinding><sp:Wss11 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Policy><sp:MustSupportRefKeyIdentifier /><sp:MustSupportRefIssuerSerial /><sp:MustSupportRefThumbprint /></sp:Policy></sp:Wss11><sp:Trust10 xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy><sp:RequireClientEntropy /><sp:RequireServerEntropy /><sp:MustSupportIssuedTokens /></wsp:Policy></sp:Trust10><sp:EncryptedParts xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><sp:Body /></sp:EncryptedParts></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[1]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         


    }

    /**
      *Constructor that takes in a configContext
      */

    public ServicioStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public ServicioStub(org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint, boolean useSeparateListener)
        throws org.apache.axis2.AxisFault {
         //To populate AxisService
         populateAxisService();
         populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,_service);
        
        _service.applyPolicy();
        
	
        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
        
            //Set the soap version
            _serviceClient.getOptions().setSoapVersionURI(org.apache.axiom.soap.SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);
        
    
    }

    /**
     * Default Constructor
     */
    public ServicioStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://localhost:8080/axis2/services/Servicio.ServicioHttpSoap12Endpoint/" );
                
    }

    /**
     * Default Constructor
     */
    public ServicioStub() throws org.apache.axis2.AxisFault {
        
                    this("http://localhost:8080/axis2/services/Servicio.ServicioHttpSoap12Endpoint/" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public ServicioStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.ws.servidor.Servicio#infoRegistro
                     * @param infoRegistro0
                    
                     */

                    

                            public  com.ws.servidor.ServicioStub.InfoRegistroResponse infoRegistro(

                            com.ws.servidor.ServicioStub.InfoRegistro infoRegistro0)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("urn:infoRegistro");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    infoRegistro0,
                                                    optimizeContent(new javax.xml.namespace.QName("http://servidor.ws.com",
                                                    "infoRegistro")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.ws.servidor.ServicioStub.InfoRegistroResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.ws.servidor.ServicioStub.InfoRegistroResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.ws.servidor.Servicio#startinfoRegistro
                    * @param infoRegistro0
                
                */
                public  void startinfoRegistro(

                 com.ws.servidor.ServicioStub.InfoRegistro infoRegistro0,

                  final com.ws.servidor.ServicioCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
             _operationClient.getOptions().setAction("urn:infoRegistro");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    infoRegistro0,
                                                    optimizeContent(new javax.xml.namespace.QName("http://servidor.ws.com",
                                                    "infoRegistro")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.ws.servidor.ServicioStub.InfoRegistroResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultinfoRegistro(
                                        (com.ws.servidor.ServicioStub.InfoRegistroResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorinfoRegistro(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
					
										            callback.receiveErrorinfoRegistro(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorinfoRegistro(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorinfoRegistro(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorinfoRegistro(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorinfoRegistro(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorinfoRegistro(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorinfoRegistro(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorinfoRegistro(f);
                                            }
									    } else {
										    callback.receiveErrorinfoRegistro(f);
									    }
									} else {
									    callback.receiveErrorinfoRegistro(f);
									}
								} else {
								    callback.receiveErrorinfoRegistro(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorinfoRegistro(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[0].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[0].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.ws.servidor.Servicio#info
                     * @param info2
                    
                     */

                    

                            public  com.ws.servidor.ServicioStub.InfoResponse info(

                            com.ws.servidor.ServicioStub.Info info2)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("urn:info");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    info2,
                                                    optimizeContent(new javax.xml.namespace.QName("http://servidor.ws.com",
                                                    "info")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.ws.servidor.ServicioStub.InfoResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.ws.servidor.ServicioStub.InfoResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.ws.servidor.Servicio#startinfo
                    * @param info2
                
                */
                public  void startinfo(

                 com.ws.servidor.ServicioStub.Info info2,

                  final com.ws.servidor.ServicioCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
             _operationClient.getOptions().setAction("urn:info");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    info2,
                                                    optimizeContent(new javax.xml.namespace.QName("http://servidor.ws.com",
                                                    "info")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.ws.servidor.ServicioStub.InfoResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultinfo(
                                        (com.ws.servidor.ServicioStub.InfoResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorinfo(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
					
										            callback.receiveErrorinfo(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorinfo(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorinfo(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorinfo(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorinfo(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorinfo(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorinfo(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorinfo(f);
                                            }
									    } else {
										    callback.receiveErrorinfo(f);
									    }
									} else {
									    callback.receiveErrorinfo(f);
									}
								} else {
								    callback.receiveErrorinfo(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorinfo(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[1].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[1].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                


       /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
       private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
       return returnMap;
    }

    
    ////////////////////////////////////////////////////////////////////////
    
    private static org.apache.neethi.Policy getPolicy (java.lang.String policyString) {
    	java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(policyString.getBytes());
    	return org.apache.neethi.PolicyEngine.getPolicy(bais);
    }
    
    /////////////////////////////////////////////////////////////////////////

    
    
    private javax.xml.namespace.QName[] opNameArray = null;
    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        

        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;   
            }
        }
        return false;
    }
     //http://localhost:8080/axis2/services/Servicio.ServicioHttpSoap12Endpoint/
        public static class InfoRegistro
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://servidor.ws.com",
                "infoRegistro",
                "ns2");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://servidor.ws.com")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Id
                        */

                        
                                    protected java.lang.String localId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIdTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getId(){
                               return localId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Id
                               */
                               public void setId(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localIdTracker = true;
                                       } else {
                                          localIdTracker = true;
                                              
                                       }
                                   
                                            this.localId=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       InfoRegistro.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://servidor.ws.com");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":infoRegistro",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "infoRegistro",
                           xmlWriter);
                   }

               
                   }
                if (localIdTracker){
                                    namespace = "http://servidor.ws.com";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"id", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"id");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("id");
                                    }
                                

                                          if (localId==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localId);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://servidor.ws.com",
                                                                      "id"));
                                 
                                         elementList.add(localId==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
                                    }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static InfoRegistro parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            InfoRegistro object =
                new InfoRegistro();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"infoRegistro".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (InfoRegistro)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://servidor.ws.com","id").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class InfoResponse
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://servidor.ws.com",
                "infoResponse",
                "ns2");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://servidor.ws.com")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for _return
                        */

                        
                                    protected java.lang.String local_return ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean local_returnTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String get_return(){
                               return local_return;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param _return
                               */
                               public void set_return(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          local_returnTracker = true;
                                       } else {
                                          local_returnTracker = true;
                                              
                                       }
                                   
                                            this.local_return=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       InfoResponse.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://servidor.ws.com");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":infoResponse",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "infoResponse",
                           xmlWriter);
                   }

               
                   }
                if (local_returnTracker){
                                    namespace = "http://servidor.ws.com";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"return", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"return");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("return");
                                    }
                                

                                          if (local_return==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(local_return);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (local_returnTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://servidor.ws.com",
                                                                      "return"));
                                 
                                         elementList.add(local_return==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_return));
                                    }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static InfoResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            InfoResponse object =
                new InfoResponse();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"infoResponse".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (InfoResponse)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://servidor.ws.com","return").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.set_return(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class Info
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://servidor.ws.com",
                "info",
                "ns2");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://servidor.ws.com")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for R
                        */

                        
                                    protected RegistroS localR ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return RegistroS
                           */
                           public  RegistroS getR(){
                               return localR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param R
                               */
                               public void setR(RegistroS param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localRTracker = true;
                                       } else {
                                          localRTracker = true;
                                              
                                       }
                                   
                                            this.localR=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Info.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://servidor.ws.com");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":info",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "info",
                           xmlWriter);
                   }

               
                   }
                if (localRTracker){
                                    if (localR==null){

                                            java.lang.String namespace2 = "http://servidor.ws.com";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"r", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"r");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("r");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localR.serialize(new javax.xml.namespace.QName("http://servidor.ws.com","r"),
                                        factory,xmlWriter);
                                    }
                                }
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localRTracker){
                            elementList.add(new javax.xml.namespace.QName("http://servidor.ws.com",
                                                                      "r"));
                            
                            
                                    elementList.add(localR==null?null:
                                    localR);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Info parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Info object =
                new Info();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"info".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Info)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://servidor.ws.com","r").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setR(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setR(RegistroS.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://base_de_datos/xsd".equals(namespaceURI) &&
                  "RegistroS".equals(typeName)){
                   
                            return  RegistroS.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    
        public static class RegistroS
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = RegistroS
                Namespace URI = http://base_de_datos/xsd
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://base_de_datos/xsd")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Descripcion
                        */

                        
                                    protected java.lang.String localDescripcion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDescripcionTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDescripcion(){
                               return localDescripcion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Descripcion
                               */
                               public void setDescripcion(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDescripcionTracker = true;
                                       } else {
                                          localDescripcionTracker = true;
                                              
                                       }
                                   
                                            this.localDescripcion=param;
                                    

                               }
                            

                        /**
                        * field for Id
                        */

                        
                                    protected java.lang.String localId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIdTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getId(){
                               return localId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Id
                               */
                               public void setId(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localIdTracker = true;
                                       } else {
                                          localIdTracker = true;
                                              
                                       }
                                   
                                            this.localId=param;
                                    

                               }
                            

                        /**
                        * field for Persona
                        */

                        
                                    protected java.lang.String localPersona ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPersonaTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPersona(){
                               return localPersona;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Persona
                               */
                               public void setPersona(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPersonaTracker = true;
                                       } else {
                                          localPersonaTracker = true;
                                              
                                       }
                                   
                                            this.localPersona=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       RegistroS.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://base_de_datos/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":RegistroS",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "RegistroS",
                           xmlWriter);
                   }

               
                   }
                if (localDescripcionTracker){
                                    namespace = "http://base_de_datos/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"descripcion", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"descripcion");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("descripcion");
                                    }
                                

                                          if (localDescripcion==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDescripcion);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIdTracker){
                                    namespace = "http://base_de_datos/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"id", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"id");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("id");
                                    }
                                

                                          if (localId==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localId);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPersonaTracker){
                                    namespace = "http://base_de_datos/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"persona", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"persona");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("persona");
                                    }
                                

                                          if (localPersona==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPersona);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localDescripcionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://base_de_datos/xsd",
                                                                      "descripcion"));
                                 
                                         elementList.add(localDescripcion==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescripcion));
                                    } if (localIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://base_de_datos/xsd",
                                                                      "id"));
                                 
                                         elementList.add(localId==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
                                    } if (localPersonaTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://base_de_datos/xsd",
                                                                      "persona"));
                                 
                                         elementList.add(localPersona==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPersona));
                                    }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static RegistroS parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            RegistroS object =
                new RegistroS();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"RegistroS".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RegistroS)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://base_de_datos/xsd","descripcion").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDescripcion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://base_de_datos/xsd","id").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://base_de_datos/xsd","persona").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPersona(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class InfoRegistroResponse
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://servidor.ws.com",
                "infoRegistroResponse",
                "ns2");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://servidor.ws.com")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for _return
                        */

                        
                                    protected RegistroS local_return ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean local_returnTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return RegistroS
                           */
                           public  RegistroS get_return(){
                               return local_return;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param _return
                               */
                               public void set_return(RegistroS param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          local_returnTracker = true;
                                       } else {
                                          local_returnTracker = true;
                                              
                                       }
                                   
                                            this.local_return=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       InfoRegistroResponse.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://servidor.ws.com");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":infoRegistroResponse",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "infoRegistroResponse",
                           xmlWriter);
                   }

               
                   }
                if (local_returnTracker){
                                    if (local_return==null){

                                            java.lang.String namespace2 = "http://servidor.ws.com";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"return", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"return");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("return");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     local_return.serialize(new javax.xml.namespace.QName("http://servidor.ws.com","return"),
                                        factory,xmlWriter);
                                    }
                                }
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (local_returnTracker){
                            elementList.add(new javax.xml.namespace.QName("http://servidor.ws.com",
                                                                      "return"));
                            
                            
                                    elementList.add(local_return==null?null:
                                    local_return);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static InfoRegistroResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            InfoRegistroResponse object =
                new InfoRegistroResponse();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"infoRegistroResponse".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (InfoRegistroResponse)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://servidor.ws.com","return").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.set_return(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.set_return(RegistroS.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
            private  org.apache.axiom.om.OMElement  toOM(com.ws.servidor.ServicioStub.InfoRegistro param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.ws.servidor.ServicioStub.InfoRegistro.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.ws.servidor.ServicioStub.InfoRegistroResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.ws.servidor.ServicioStub.InfoRegistroResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.ws.servidor.ServicioStub.Info param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.ws.servidor.ServicioStub.Info.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.ws.servidor.ServicioStub.InfoResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.ws.servidor.ServicioStub.InfoResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.ws.servidor.ServicioStub.InfoRegistro param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.ws.servidor.ServicioStub.InfoRegistro.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.ws.servidor.ServicioStub.Info param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.ws.servidor.ServicioStub.Info.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (com.ws.servidor.ServicioStub.InfoRegistro.class.equals(type)){
                
                           return com.ws.servidor.ServicioStub.InfoRegistro.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.ws.servidor.ServicioStub.InfoRegistroResponse.class.equals(type)){
                
                           return com.ws.servidor.ServicioStub.InfoRegistroResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.ws.servidor.ServicioStub.Info.class.equals(type)){
                
                           return com.ws.servidor.ServicioStub.Info.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.ws.servidor.ServicioStub.InfoResponse.class.equals(type)){
                
                           return com.ws.servidor.ServicioStub.InfoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   