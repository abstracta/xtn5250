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



package net.infordata.em.tn5250;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class XI5250EmulatorBeanInfo extends SimpleBeanInfo {
  Class<XI5250Emulator> beanClass = XI5250Emulator.class;
  String iconColor16x16Filename = "resources/XI5250Emulator_16.gif";
  String iconColor32x32Filename = "resources/XI5250Emulator_32.gif";
  String iconMono16x16Filename;
  String iconMono32x32Filename;


  public XI5250EmulatorBeanInfo() {
  }

  @Override
  public PropertyDescriptor[] getPropertyDescriptors() {
    try  {
      PropertyDescriptor _active =
          new PropertyDescriptor("active", beanClass, "isActive", "setActive");

      PropertyDescriptor _host =
          new PropertyDescriptor("host", beanClass, "getHost", "setHost");

      PropertyDescriptor _keyboardQueue =
          new PropertyDescriptor("keyboardQueue", beanClass,
                                 "isKeyboardQueue", "setKeyboardQueue");

      PropertyDescriptor _terminalType =
          new PropertyDescriptor("terminalType", beanClass,
                                 "getTerminalType", "setTerminalType");
      
      PropertyDescriptor _altFKeyRemap =
        new PropertyDescriptor("altFKeyRemap", beanClass,
                               "getAltFKeyRemap", "setAltFKeyRemap");

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _active,
        _host,
        _keyboardQueue,
        _terminalType,
        _altFKeyRemap,
      };
      return pds;
    }
    catch (IntrospectionException ex) {
      ex.printStackTrace();
      return null;
    }
  }

  @Override
  public java.awt.Image getIcon(int iconKind) {
    switch (iconKind) {
    case BeanInfo.ICON_COLOR_16x16:
      return iconColor16x16Filename != null ? loadImage(iconColor16x16Filename) : null;
    case BeanInfo.ICON_COLOR_32x32:
      return iconColor32x32Filename != null ? loadImage(iconColor32x32Filename) : null;
    case BeanInfo.ICON_MONO_16x16:
      return iconMono16x16Filename != null ? loadImage(iconMono16x16Filename) : null;
    case BeanInfo.ICON_MONO_32x32:
      return iconMono32x32Filename != null ? loadImage(iconMono32x32Filename) : null;
    }
    return null;
  }

  @Override
  public BeanInfo[] getAdditionalBeanInfo() {
    Class<?> superclass = beanClass.getSuperclass();
    try  {
      BeanInfo superBeanInfo = Introspector.getBeanInfo(superclass);
      return new BeanInfo[] { superBeanInfo };
    }
    catch (IntrospectionException ex) {
      ex.printStackTrace();
      return null;
    }
  }
}

