package com.jd.assignemnt;

public class TriangleLibJNI {
    static {
        System.loadLibrary("native-lib");
    }

    public static native void on_surface_created();

    public static native void on_surface_changed(int width, int height);

    public static native void on_draw_frame();

    public static native void NativeLibrary_init(int width, int height);

    public static native void NativeLibrary_step();
}
