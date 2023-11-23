package storage;

import labtests.util.StructureTest;
import labtests.util.specs.ClassSpec;
import labtests.util.specs.ConstructorSpec;
import labtests.util.specs.FieldSpec;
import labtests.util.specs.MethodSpec;

public class LinkedMapStructureTest extends StructureTest
{
    @Override
    protected String getClassName()
    {
        return "storage.LinkedMap";
    }

    @Override
    protected ClassSpec getClassSpec()
    {
        return new ClassSpec(getClassName(), "public", false, false, false, new String[]{"K", "V"});
    }

    @Override
    protected ConstructorSpec[] getConstructorSpecs()
    {
        return new ConstructorSpec[]{
            new ConstructorSpec(getClassName(), "public", new String[]{}),
        };
    }

    @Override
    protected FieldSpec[] getFieldSpecs()
    {
        return new FieldSpec[]{
            new FieldSpec("head", "private", false, false, "storage.Node"),
            new FieldSpec("manyNodes", "private", false, false, "int")
        };
    }

    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[]{
            new MethodSpec("clear", "public", false, false, false, false,
                new String[]{}, "void"),
            new MethodSpec("containsKey", "public", false, false, false, false,
                new String[]{"java.lang.Object"}, "boolean"),
            new MethodSpec("containsValue", "public", false, false, false, false,
                new String[]{"java.lang.Object"}, "boolean"),
            new MethodSpec("get", "public", false, false, false, false,
                new String[]{"java.lang.Object"}, "java.lang.Object"),
            new MethodSpec("put", "public", false, false, false, false,
                new String[]{"java.lang.Object", "java.lang.Object"}, "java.lang.Object"),
            new MethodSpec("remove", "public", false, false, false, false,
                new String[]{"java.lang.Object"}, "java.lang.Object"),
            new MethodSpec("isEmpty", "public", false, false, false, false,
                new String[]{}, "boolean"),
            new MethodSpec("size", "public", false, false, false, false,
                new String[]{}, "int"),
            new MethodSpec("values", "public", false, false, false, false,
                new String[]{}, "java.util.Collection"),
            new MethodSpec("entrySet", "public", false, false, false, false,
                new String[]{}, "java.util.Set"),
            new MethodSpec("keySet", "public", false, false, false, false,
                new String[]{}, "java.util.Set"),
            new MethodSpec("putAll", "public", false, false, false, false,
                new String[]{"java.util.Map"}, "void"),
        };
    }

    @Override
    protected String[] getInterfacesImplemented()
    {
        return new String[]{"java.util.Map"};
    }
}
