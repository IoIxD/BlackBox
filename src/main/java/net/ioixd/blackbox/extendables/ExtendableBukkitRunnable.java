package net.ioixd.blackbox.extendables;

import net.ioixd.blackbox.BlackBox;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class ExtendableBukkitRunnable extends BukkitRunnable {
    public String name;
    public String inLibName;
    public BlackBox blackBox;

    @Override
    public synchronized BukkitTask runTask(Plugin arg0) throws IllegalArgumentException, IllegalStateException {
        Object result = null;
        try {
            result = Misc.tryExecute(this.blackBox, this.inLibName, this.name, "BukkitTask", "runTask",
                    new Object[] {
                            arg0
                    }, false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (result == null) {
            return super.runTask(arg0);
        } else {
            return (BukkitTask) result;
        }
    }

    @Override
    public synchronized BukkitTask runTaskAsynchronously(Plugin arg0)
            throws IllegalArgumentException, IllegalStateException {
        Object result = null;
        try {
            result = Misc.tryExecute(this.blackBox, this.inLibName, this.name, "BukkitTask", "runTaskAsynchronously",
                    new Object[] {
                            arg0
                    }, false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (result == null) {
            return super.runTaskAsynchronously(arg0);
        } else {
            return (BukkitTask) result;
        }
    }

    @Override
    public synchronized BukkitTask runTaskLater(Plugin arg0, long arg1)
            throws IllegalArgumentException, IllegalStateException {
        Object result = null;
        try {
            result = Misc.tryExecute(this.blackBox, this.inLibName, this.name, "BukkitTask", "runTaskLater",
                    new Object[] {
                            arg0, arg1
                    }, false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (result == null) {
            return super.runTaskLater(arg0, arg1);
        } else {
            return (BukkitTask) result;
        }
    }

    @Override
    public synchronized BukkitTask runTaskLaterAsynchronously(Plugin arg0, long arg1)
            throws IllegalArgumentException, IllegalStateException {
        Object result = null;
        try {
            result = Misc.tryExecute(this.blackBox, this.inLibName, this.name, "BukkitTask",
                    "runTaskLaterAsynchronously",
                    new Object[] {
                            arg0, arg1
                    }, false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (result == null) {
            return super.runTaskLaterAsynchronously(arg0, arg1);
        } else {
            return (BukkitTask) result;
        }
    }

    @Override
    public synchronized BukkitTask runTaskTimer(Plugin arg0, long arg1, long arg2)
            throws IllegalArgumentException, IllegalStateException {
        Object result = null;
        try {
            result = Misc.tryExecute(this.blackBox, this.inLibName, this.name, "BukkitTask", "runTaskTimer",
                    new Object[] {
                            arg0, arg1, arg2
                    }, false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (result == null) {
            return super.runTaskTimer(arg0, arg1, arg2);
        } else {
            return (BukkitTask) result;
        }
    }

    @Override
    public synchronized BukkitTask runTaskTimerAsynchronously(Plugin arg0, long arg1, long arg2)
            throws IllegalArgumentException, IllegalStateException {
        Object result = null;
        try {
            result = Misc.tryExecute(this.blackBox, this.inLibName, this.name, "BukkitTask",
                    "runTaskTimerAsynchronously",
                    new Object[] {
                            arg0, arg1, arg2
                    }, false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (result == null) {
            return super.runTaskTimerAsynchronously(arg0, arg1, arg2);
        } else {
            return (BukkitTask) result;
        }
    }

    ExtendableBukkitRunnable(Plugin blackBox, String name, String inLibName) {
        this.blackBox = (BlackBox) blackBox;
        this.name = name;
        this.inLibName = inLibName;
        Misc.throwIfFuncsNotBound(this.inLibName, this.name, this.getClass());
    }

    public void run() {
        try {
            Misc.tryExecute(this.blackBox, this.inLibName, this.name, "BukkitRunnable", "run",
                    new Object[] {}, true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}