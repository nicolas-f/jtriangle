package org.orbisgis.jtriangle;

import org.junit.Test;
import org.renjin.gcc.runtime.CharPtr;
import org.renjin.gcc.runtime.DoublePtr;
import org.renjin.gcc.runtime.IntPtr;
import org.renjin.gcc.runtime.Ptr;

/**
 * Example of using a compiled C function from Java
 */
public class JTriangleTest {

  @Test
  public void simplePointMesh() {
    Ptr mid = triangle.createEmptyStruct();
    Ptr vorout = triangle.createEmptyStruct();

    int numberofpointattributes = 1;

    double[] pointlist = new double[] {0,0,1,0,1,10,0,10};
    double[] pointAttribute = new double[] {0, 1, 11, 10};
    double[] pointMarker = new double[] {0, 2, 0, 0};
    double[] regions = new double[] {0.5,5,
    7,  /* Regional attribute (for whole mesh). */
    0.1 /* Area constraint that will not be used. */
    };

    Ptr in = triangle.createInputStruct(new DoublePtr(pointlist), new DoublePtr(pointAttribute),
            new DoublePtr(pointMarker),pointlist.length/2,numberofpointattributes,new IntPtr(),new DoublePtr(),
            new DoublePtr(),0, 0,0,new IntPtr(0),new IntPtr(),0,new DoublePtr(),0,new DoublePtr(regions), regions.length/4);


    // Run triangulation
    triangle.triangulate(new CharPtr("pczAevn".toCharArray()), in, mid, vorout);

    assert(true);
  }

}
