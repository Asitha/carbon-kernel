/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.axiom.ts.soap.fault;

import org.apache.axiom.om.OMMetaFactory;
import org.apache.axiom.soap.SOAPFault;
import org.apache.axiom.ts.soap.SOAPSpec;
import org.apache.axiom.ts.soap.SOAPTestCase;

public class TestSetRole extends SOAPTestCase {
    public TestSetRole(OMMetaFactory metaFactory, SOAPSpec spec) {
        super(metaFactory, spec);
    }

    protected void runTest() throws Throwable {
        SOAPFault soapFault = soapFactory.createSOAPFault();
        soapFault.setRole(soapFactory.createSOAPFaultRole(soapFault));
        assertNotNull(
                "Fault Test:- After calling setRole method, Fault has no role",
                soapFault.getRole());
        assertEquals("Fault Test:- Fault role local name mismatch",
                spec.getFaultRoleQName(), soapFault.getRole().getQName());
        try {
            soapFault.setRole(altSoapFactory.createSOAPFaultRole());
            fail("SOAPFaultRole should not be set in to a SOAPFault for a different SOAP version");
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}