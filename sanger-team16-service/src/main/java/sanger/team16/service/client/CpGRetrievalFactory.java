/**
 *  This file is part of Genevar (GENe Expression VARiation)
 *  Copyright (C) 2013  Genome Research Ltd.
 *
 *  Genevar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package sanger.team16.service.client;

import sanger.team16.service.CpGRetrievalService;

/**
 * @author Tsun-Po Yang <tpy@sanger.ac.uk>
 * @link   http://www.sanger.ac.uk/resources/software/genevar/
 * @date   21/09/13
 */
public final class CpGRetrievalFactory extends AbstractFactory
{
    public CpGRetrievalFactory(String address, String username, String password) {
        super(address, username, password);
    }
    
    public CpGRetrievalService create() {
        proxyFactory.setServiceClass(CpGRetrievalService.class);
        proxyFactory.setAddress(address + "/CpGRetrieval");

        return (CpGRetrievalService) proxyFactory.create();
    }
}
