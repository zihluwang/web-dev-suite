package cn.vorbote.web.utils;

import cn.vorbote.core.util.StringUtil;
import cn.vorbote.web.constants.WebStatus;
import cn.vorbote.web.exceptions.BizException;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

/**
 * <br>
 * Created at 2022/2/22 22:22
 *
 * @author vorbote theodore0126@outlook.com
 */
public final class BizAssert {

    /**
     * Private constructor, to hide the constructor to prevent some build a instance of this util class.
     */
    private BizAssert() {
    }

    /**
     * Assert that the given text does not contain the given substring.
     * <pre class="code">BizAssert.doesNotContain(name, "rod", "Name must not contain \"rod\".");</pre>
     *
     * @param textToSearch The text to search.
     * @param substring    The substring to find within the text.
     * @param message      The exception message to use if the assertion fails.
     * @throws BizException If the text contains the substring.
     */
    public static void doesNotContain(String textToSearch, String substring, String message) throws BizException {
        if (!textToSearch.isBlank() && textToSearch.contains(substring)) {
            throw new BizException(WebStatus.BAD_REQUEST, message);
        }
    }

    /**
     * Assert that the given text does not contain the given substring.
     * <pre class="code">
     * BizAssert.doesNotContain(name, forbidden, () -> "Name must not contain  ");
     * </pre>
     *
     * @param textToSearch    The text to search.
     * @param substring       The substring to find within the text.
     * @param messageSupplier The exception message to use if the assertion fails.
     * @throws BizException If the text contains the substring.
     */
    public static void doesNotContain(String textToSearch, String substring, Supplier<String> messageSupplier) {
        if (!textToSearch.isBlank() && textToSearch.contains(substring)) {
            throw new BizException(WebStatus.BAD_REQUEST, getMessageFromSupplier(messageSupplier));
        }
    }

    public static void hasLength(String text, String message) {
        if (StringUtil.hasLength(text)) {
            throw new BizException(WebStatus.BAD_REQUEST, message);
        }
    }

    public static void hasLength(String text, Supplier<String> messageSupplier) {
        if (StringUtil.hasLength(text)) {
            throw new BizException(WebStatus.BAD_REQUEST, getMessageFromSupplier(messageSupplier));
        }
    }

    public static void hasText(String text, String message) {
        if (!StringUtil.hasText(text)) {
            throw new BizException(WebStatus.BAD_REQUEST, message);
        }
    }

    public static void hasText(String text, Supplier<String> messageSupplier) {
        if (!StringUtil.hasText(text)) {
            throw new BizException(WebStatus.BAD_REQUEST, getMessageFromSupplier(messageSupplier));
        }
    }

    public static void isAssignable(Class<?> superType, Class<?> subType, String message) {

    }

    public static void isAssignable(Class<?> superType, Class<?> subType, Supplier<String> messageSupplier) {

    }

    public static void isInstanceOf(Class<?> type, Object object, String message) {

    }

    public static void isInstanceOf(Class<?> type, Object object, Supplier<String> messageSupplier) {

    }

    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new BizException(WebStatus.BAD_REQUEST, message);
        }
    }

    public static void isNull(Object object, Supplier<String> messageSupplier) {
        if (object != null) {
            throw new BizException(WebStatus.BAD_REQUEST, getMessageFromSupplier(messageSupplier));
        }
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BizException(WebStatus.BAD_REQUEST, message);
        }
    }

    public static void isTrue(boolean expression, Supplier<String> messageSupplier) {
        if (!expression) {
            throw new BizException(WebStatus.BAD_REQUEST, getMessageFromSupplier(messageSupplier));
        }
    }

    public static void noNullElements(Collection<?> collection, String message) {

    }

    public static void noNullElements(Collection<?> collection, Supplier<String> messageSupplier) {

    }

    public static void noNullElements(Object[] array, String message) {

    }

    public static void noNullElements(Object[] array, Supplier<String> messageSupplier) {

    }

    public static void notEmpty(Collection<?> collection, String message) {

    }

    public static void notEmpty(Collection<?> collection, Supplier<String> messageSupplier) {

    }

    public static void notEmpty(Map<?, ?> map, String message) {

    }

    public static void notEmpty(Map<?, ?> map, Supplier<String> messageSupplier) {

    }

    public static void notEmpty(Object[] array, String message) {
        if (array == null || array.length == 0) {
            throw new BizException(WebStatus.BAD_REQUEST, message);
        }
    }

    public static void notEmpty(Object[] array, Supplier<String> messageSupplier) {
        if (array == null || array.length == 0) {
            throw new BizException(WebStatus.BAD_REQUEST, getMessageFromSupplier(messageSupplier));
        }
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new BizException(WebStatus.BAD_REQUEST, message);
        }
    }

    public static void notNull(Object object, Supplier<String> messageSupplier) {
        if (object == null) {
            throw new BizException(WebStatus.BAD_REQUEST, getMessageFromSupplier(messageSupplier));
        }
    }

    public static void state(boolean expression, String message) {
        if (!expression) {
            throw new BizException(WebStatus.BAD_REQUEST, message);
        }
    }

    public static void state(boolean expression, Supplier<String> messageSupplier) {
        if (!expression) {
            throw new BizException(WebStatus.BAD_REQUEST, getMessageFromSupplier(messageSupplier));
        }
    }

    private static boolean endsWithSeparator(String message) {
        return (message.endsWith(":") || message.endsWith(";") || message.endsWith(",") || message.endsWith("."));
    }

    private static String messageWithTypeName(String message, Object typeName) {
        return message + (message.endsWith(" ") ? "" : ": ") + typeName;
    }

    private static void instanceCheckFailed(Class<?> type, Object obj, String message) {
        var className = (obj != null ? obj.getClass().getName() : "null");
        var result = "";
        var defaultMessage = true;

        if (!message.isBlank()) {
            if (endsWithSeparator(message)) {
                result = message + " ";
            } else {
                result = messageWithTypeName(message, className);
                defaultMessage = false;
            }
        }

        if (defaultMessage) {
            result += ("Object of class [" + className + "] must be an instance of " + type);
        }

        throw new BizException(WebStatus.BAD_REQUEST, result);
    }

    private static void assignableCheckFailed(Class<?> superType, Class<?> subType, String message) {
        var result = "";
        var defaultMessage = true;
        if (!message.isBlank()) {
            if (endsWithSeparator(message)) {
                result = message + " ";
            } else {
                result = messageWithTypeName(message, subType);
                defaultMessage = false;
            }
        }

        if (defaultMessage) {
            result += (subType + " is not assignable to " + superType);
        }

        throw new BizException(WebStatus.BAD_REQUEST, result);
    }

    private static String getMessageFromSupplier(Supplier<String> messageSupplier) {
        return (messageSupplier != null) ? messageSupplier.get() : null;
    }

}
