#include <jni.h>
#include <string>
#include <regex>

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_eugene_1dolgushev_contact_contactAdd_domain_models_ContactPhoneValidator_validatePhone(
        JNIEnv *env, jobject thiz, jstring phone) {
    const jclass stringClass = env->GetObjectClass(phone);
    const jmethodID getBytes = env->GetMethodID(stringClass, "getBytes", "(Ljava/lang/String;)[B");
    const jbyteArray stringJbytes = (jbyteArray) env->CallObjectMethod(phone, getBytes,
                                                                       env->NewStringUTF("UTF-8"));

    size_t length = (size_t) env->GetArrayLength(stringJbytes);
    jbyte *pBytes = env->GetByteArrayElements(stringJbytes, NULL);

    env->ReleaseByteArrayElements(stringJbytes, pBytes, JNI_ABORT);
    env->DeleteLocalRef(stringJbytes);
    env->DeleteLocalRef(stringClass);

    std::string formattedPhone = std::string((char *) pBytes, length);
    return std::regex_match(formattedPhone, std::regex("^(\\+7)?[0-9]{10}\$"));
}