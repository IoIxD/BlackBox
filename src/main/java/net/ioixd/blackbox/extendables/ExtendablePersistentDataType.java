package net.ioixd.blackbox.extendables;

import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class ExtendablePersistentDataType implements PersistentDataType {
    public String name;
    public String inLibName;
    public Plugin plugin;
    public int address;

    public ExtendablePersistentDataType(int address, Plugin plugin, String name, String inLibName) {

        this.plugin = plugin;
        this.address = address;
        this.name = name;
        this.inLibName = inLibName;
        Misc.throwIfFuncsNotBound(this.inLibName, this.name, this.getClass());
    }

    public java.lang.Class<?> getPrimitiveType() {
        Object result = null;
        try {
            result = Misc.tryExecute(this.inLibName, this.name, "PersistentDataType", "getPrimitiveType",
                    address, plugin, new Object[] {}, true, true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return (java.lang.Class<?>) result;
    }

    public java.lang.Class<?> getComplexType() {
        Object result = null;
        try {
            result = Misc.tryExecute(this.inLibName, this.name, "PersistentDataType", "getComplexType",
                    address, plugin, new Object[] {}, true, true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return (java.lang.Class<?>) result;
    }

    public java.lang.Object toPrimitive(java.lang.Object arg0,
            org.bukkit.persistence.PersistentDataAdapterContext arg1) {
        Object result = null;
        try {
            result = Misc.tryExecute(this.inLibName, this.name, "PersistentDataType", "toPrimtive",
                    address, plugin, new Object[] { arg0, arg1 }, true, true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return (java.lang.Object) result;
    }

    public java.lang.Object fromPrimitive(java.lang.Object arg0,
            org.bukkit.persistence.PersistentDataAdapterContext arg1) {
        Object result = null;
        try {
            result = Misc.tryExecute(this.inLibName, this.name, "PersistentDataType", "fromPrimitive",
                    address, plugin, new Object[] { arg0, arg1 }, true, true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return (java.lang.Object) result;
    }
}