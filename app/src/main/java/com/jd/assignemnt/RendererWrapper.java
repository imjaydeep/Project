package com.jd.assignemnt;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;

public class RendererWrapper implements Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        TriangleLibJNI.on_surface_created();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        TriangleLibJNI.on_surface_changed(width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        TriangleLibJNI.on_draw_frame();

    }

}
