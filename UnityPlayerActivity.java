protected void switchWideScreen() {<br>        Object am = getSystemService(Context.ACTIVITY_SERVICE);
        Class cl = am.getClass();
        Method[] methods = cl.getMethods();
        Method setWideScreenMode = null;
        Method moveToDisplayAsDisplayId = null;
        //try to get the methods we need and invoke them
        try {
            //move app to main screen
            moveToDisplayAsDisplayId = cl.getMethod("moveToDisplayAsDisplayId", int.class, int.class);
            moveToDisplayAsDisplayId.invoke(am, 1, 0);
            //go into widescreen
            setWideScreenMode = cl.getMethod("setWideScreenMode", boolean.class);
            setWideScreenMode.invoke(am, true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
