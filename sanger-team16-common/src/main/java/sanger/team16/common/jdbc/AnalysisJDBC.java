/**
 *  This file is part of Genevar (GENe Expression VARiation)
 *  Copyright (C) 2010  Genome Research Ltd.
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
package sanger.team16.common.jdbc;

/**
 * @author Tsun-Po Yang <tpy@sanger.ac.uk>
 * @link   http://www.sanger.ac.uk/resources/software/genevar/
 */
public class AnalysisJDBC extends AbstractJDBC
{
    public AnalysisJDBC(String address) {
        super(address);
    }

    public void loadDataLocalInfile(int featureId, String loadFile) {
        if (System.getProperty("os.name").toLowerCase().indexOf("windows") != -1)
            loadFile = replaceBackslashWithDoubleBackslash(loadFile);
        
        String sql = "LOAD DATA LOCAL INFILE '" + loadFile + "' " +
            "INTO TABLE analysis (probe_primary_id, variation_id, value, value1, value2, value3, value4) " +
            "SET analysis_feature_id = " + featureId;
        
        this.execute(sql);
    }
    
    public void varDataLocalInfile(int studyId, int genotypeFeatureId, String loadFile) {
        if (System.getProperty("os.name").toLowerCase().indexOf("windows") != -1)
            loadFile = replaceBackslashWithDoubleBackslash(loadFile);
        
        String sql = "LOAD DATA LOCAL INFILE '" + loadFile + "' " +
            "INTO TABLE variation (name, chromosome, position, alleles) " +
            "SET study_id = " + studyId + ", genotype_feature_id = " +  genotypeFeatureId;

        this.execute(sql);
    }
    
    public void infoDataLocalInfile(String loadFile) {
        if (System.getProperty("os.name").toLowerCase().indexOf("windows") != -1)
            loadFile = replaceBackslashWithDoubleBackslash(loadFile);
        
        String sql = "LOAD DATA LOCAL INFILE '" + loadFile + "' " +
            "INTO TABLE variation_info (variation_id, info, freq1) ";

        this.execute(sql);
    }
}
