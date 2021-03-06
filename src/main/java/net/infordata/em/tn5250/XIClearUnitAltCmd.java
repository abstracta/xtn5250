/*
Copyright 2007 Infordata S.p.A.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

/*
!!V 14/07/97 rel. 1.02 - added support for 27x132 terminal type (IBM-3477-FC).
    ***
    30/06/98 rel. _.___- Swing, JBuilder2 e VSS.
 */

package net.infordata.em.tn5250;

import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;

/**
 * Clear Unit Alternative
 *
 * @author   Valentino Proietti - Infordata S.p.A.
 */
public class XIClearUnitAltCmd extends XI5250Cmd {

  protected int ivPar;

  @Override
  protected void readFrom5250Stream(InputStream inStream) throws IOException, XI5250Exception {
    ivPar = Math.max(0, inStream.read());
    if (ivPar != 0x00 && ivPar != 0x80)
      throw new XI5250Exception("Invalid clear unit param: " + ivPar, 
          XI5250Emulator.ERR_INVALID_CLEAR_UNIT_ALT);
  }

  @Override
  protected void execute() {
    ivEmulator.setState(XI5250Emulator.ST_NORMAL_LOCKED);
    ivEmulator.ivPendingCmd = null;

    if (ivEmulator.ivPrevFont == null) {
      Font ft = ivEmulator.getFont();
      ivEmulator.ivPrevFont = new Font(ft.getName(), ft.getStyle(), ft.getSize());
    }

    ivEmulator.setCrtSize(132, 27);

    ivEmulator.setDefAttr(0x20);
    ivEmulator.clear();
    ivEmulator.removeFields();
    ivEmulator.setErrorRow(ivEmulator.getCrtSize().height - 1);
  }

}
