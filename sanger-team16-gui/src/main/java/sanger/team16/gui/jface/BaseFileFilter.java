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
package sanger.team16.gui.jface;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * @author Tsun-Po Yang <tpy@sanger.ac.uk>
 * @link   http://www.sanger.ac.uk/Teams/Team16/
 */
public class BaseFileFilter extends FileFilter
{
	private String extension;
	private String description;
	
	public BaseFileFilter(String extension, String description) {
        this.extension = extension;
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
  
    public boolean accept(File file) {
          String name = file.getName().toLowerCase();
          
          if (file.isDirectory())
            return true;
          if (name.endsWith(extension))
            return true;

          return false;
    }
}