package com.haveacupofjava.happyfarm.security;

public class PackageChecker {

    private static final String SAFE_PACKAGE_NAME = "com.haveacupofjava.happyfarm";

    /**
     * Checks if the package of the caller method is safe
     * @throws MethodExposedException if the package is not safe
     */
    public static void checkPackage() throws MethodExposedException {
        String callerMethodName = Thread.currentThread().getStackTrace()[3].toString();
        if (!isMethodNameSafe(callerMethodName)) {
            throw new MethodExposedException("HappyFarm library method exposed to " +
                    callerMethodName);
        }
    }

    /**
     * Returns true if the method name is safe to call the library method
     * @param methodName The method name
     * @return True if the method name is safe to call the library method
     */
    private static boolean isMethodNameSafe(String methodName) {
        return (methodName.length() >= SAFE_PACKAGE_NAME.length()) &&
                methodName.substring(0, SAFE_PACKAGE_NAME.length()).equals(SAFE_PACKAGE_NAME);
    }

}
