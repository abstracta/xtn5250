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
!!V 14/05/97 rel. 0.96d- removed SIZE_CHANGED.
    27/05/97 rel. 1.00 - first release.
    03/03/98 rel. _.___- SWING and reorganization.
    ***
    30/06/98 rel. _.___- Swing, JBuilder2 e VSS.
 */

package net.infordata.em.crt5250;

import java.util.EventListener;

/**
 * Listener for XI5250FieldEvent.
 *
 * @author Valentino Proietti - Infordata S.p.A.
 */
public interface XI5250FieldListener extends EventListener {

  /**
   * Input cursor enters in the field area
   *
   * @param e triggered event.
   */
  void activated(XI5250FieldEvent e);

  /**
   * Input cursor exits from the input area
   *
   * @param e triggered event.
   */
  void deactivated(XI5250FieldEvent e);

  /**
   * Field value is changed
   *
   * @param e triggered event.
   */
  void valueChanged(XI5250FieldEvent e);

  /**
   * Field enabled state is changed using setEnabled method
   *
   * @param e triggered event.
   * @see XI5250Field#setEnabled
   * @see XI5250Field#isEnabled
   */
  void enabledStateChanged(XI5250FieldEvent e);

  void keyEvent(XI5250FieldEvent e);

}
