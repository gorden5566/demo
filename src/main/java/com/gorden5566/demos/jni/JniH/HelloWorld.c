#include "jni.h"
#include "HelloWorld.h"
#include <stdio.h>

// gcc -dynamiclib -I /Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/include -I /Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/include/darwin HelloWorld.c -o libhello.jnilib
JNIEXPORT void JNICALL Java_com_gorden5566_demos_jni_HelloWorld_sayHello
  (JNIEnv * env, jobject obj) {
    printf("Helloworld!\n");
    return;
}