package org.orbisgis.jtriangle;

import org.junit.Test;
import org.renjin.gcc.runtime.Ptr;

/**
 * Example of using a compiled C function from Java
 */
public class JTriangleTest {

  @Test
  public void simplePointMesh() {
    Ptr out = triangle.createEmptyStruct();
    assert(true);
  }

}
