/*
 * Copyright (c) 2017 - 2021, SmartDeviceLink Consortium, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided with the
 * distribution.
 *
 * Neither the name of the SmartDeviceLink Consortium Inc. nor the names of
 * its contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.smartdevicelink.proxy.rpc;

import com.smartdevicelink.proxy.RPCStruct;
import com.smartdevicelink.proxy.rpc.enums.KeyboardInputMask;
import com.smartdevicelink.proxy.rpc.enums.KeyboardLayout;
import com.smartdevicelink.proxy.rpc.enums.KeypressMode;
import com.smartdevicelink.proxy.rpc.enums.Language;

import java.util.Hashtable;
import java.util.List;

/**
 * Configuration of on-screen keyboard (if available).
 *
 * <p><b>Parameter List</b></p>
 *
 * <table border="1" rules="all">
 *  <tr>
 *      <th>Param Name</th>
 *      <th>Type</th>
 *      <th>Description</th>
 *      <th>Required</th>
 *      <th>Notes</th>
 *      <th>Version Available</th>
 *  </tr>
 *  <tr>
 *      <td>language</td>
 *      <td>Language</td>
 *      <td>The keyboard language.</td>
 *      <td>N</td>
 *      <td></td>
 *      <td></td>
 *  </tr>
 *  <tr>
 *      <td>keyboardLayout</td>
 *      <td>KeyboardLayout</td>
 *      <td>Desired keyboard layout.</td>
 *      <td>N</td>
 *      <td></td>
 *      <td></td>
 *  </tr>
 *  <tr>
 *      <td>keypressMode</td>
 *      <td>KeypressMode</td>
 *      <td>Desired keypress mode. If omitted, this value will be set to RESEND_CURRENT_ENTRY.</td>
 *      <td>N</td>
 *      <td></td>
 *      <td></td>
 *  </tr>
 *  <tr>
 *      <td>limitedCharacterList</td>
 *      <td>List<String></td>
 *      <td>Array of keyboard characters to enable.All omitted characters will be greyed out(disabled) on the keyboard.If omitted, the entire keyboard will be enabled.</td>
 *      <td>N</td>
 *      <td>{"string_max_length": 1, "string_min_length": 1, "array_max_size": 100, "array_min_size": 1}</td>
 *      <td></td>
 *  </tr>
 *  <tr>
 *      <td>autoCompleteText</td>
 *      <td>String</td>
 *      <td>Deprecated, use autoCompleteList instead.</td>
 *      <td>N</td>
 *      <td>{"string_max_length": 1000, "string_min_length": 1}</td>
 *      <td>
 *         @since SmartDeviceLink 3.0.0
 *         @deprecated in SmartDeviceLink 6.0.0
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>autoCompleteList</td>
 *      <td>List<String></td>
 *      <td>Allows an app to pre-populate the text field with a list of suggested or completed entriesas the user types. If empty, the auto-complete list will be removed from the screen.</td>
 *      <td>N</td>
 *      <td>{"string_max_length": 1000, "string_min_length": 1, "array_max_size": 100, "array_min_size": 0}</td>
 *      <td>
 *         @since SmartDeviceLink 6.0.0
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>maskInputCharacters</td>
 *      <td>KeyboardInputMask</td>
 *      <td>Allows an app to mask entered characters on HMI</td>
 *      <td>N</td>
 *      <td></td>
 *      <td>
 *         @since SmartDeviceLink 7.1.0
 *      </td>
 *  </tr>
 *  <tr>
 *      <td>customKeys</td>
 *      <td>List<String></td>
 *      <td>Array of special characters to show in customizable keys. If omitted, keyboard will showdefault special characters</td>
 *      <td>N</td>
 *      <td>{"string_max_length": 1, "string_min_length": 1, "array_max_size": 10, "array_min_size": 1}</td>
 *      <td>
 *         @since SmartDeviceLink 7.1.0
 *      </td>
 *  </tr>
 * </table>
 *
 * @since SmartDeviceLink 3.0.0
 */
public class KeyboardProperties extends RPCStruct {
    public static final String KEY_LANGUAGE = "language";
    public static final String KEY_KEYBOARD_LAYOUT = "keyboardLayout";
    public static final String KEY_KEYPRESS_MODE = "keypressMode";
    public static final String KEY_LIMITED_CHARACTER_LIST = "limitedCharacterList";
    /**
     * @since SmartDeviceLink 3.0.0
     * @deprecated in SmartDeviceLink 6.0.0
     */
    @Deprecated
    public static final String KEY_AUTO_COMPLETE_TEXT = "autoCompleteText";
    /**
     * @since SmartDeviceLink 6.0.0
     */
    public static final String KEY_AUTO_COMPLETE_LIST = "autoCompleteList";
    /**
     * @since SmartDeviceLink 7.1.0
     */
    public static final String KEY_MASK_INPUT_CHARACTERS = "maskInputCharacters";
    /**
     * @since SmartDeviceLink 7.1.0
     */
    public static final String KEY_CUSTOM_KEYS = "customKeys";

    /**
     * Constructs a new KeyboardProperties object
     */
    public KeyboardProperties() { }

    /**
     * Constructs a new KeyboardProperties object indicated by the Hashtable parameter
     *
     * @param hash The Hashtable to use
     */
    public KeyboardProperties(Hashtable<String, Object> hash) {
        super(hash);
    }

    /**
     * Sets the language.
     *
     * @param language The keyboard language.
     */
    public KeyboardProperties setLanguage(Language language) {
        setValue(KEY_LANGUAGE, language);
        return this;
    }

    /**
     * Gets the language.
     *
     * @return Language The keyboard language.
     */
    public Language getLanguage() {
        return (Language) getObject(Language.class, KEY_LANGUAGE);
    }

    /**
     * Sets the keyboardLayout.
     *
     * @param keyboardLayout Desired keyboard layout.
     */
    public KeyboardProperties setKeyboardLayout(KeyboardLayout keyboardLayout) {
        setValue(KEY_KEYBOARD_LAYOUT, keyboardLayout);
        return this;
    }

    /**
     * Gets the keyboardLayout.
     *
     * @return KeyboardLayout Desired keyboard layout.
     */
    public KeyboardLayout getKeyboardLayout() {
        return (KeyboardLayout) getObject(KeyboardLayout.class, KEY_KEYBOARD_LAYOUT);
    }

    /**
     * Sets the keypressMode.
     *
     * @param keypressMode Desired keypress mode. If omitted, this value will be set to RESEND_CURRENT_ENTRY.
     */
    public KeyboardProperties setKeypressMode(KeypressMode keypressMode) {
        setValue(KEY_KEYPRESS_MODE, keypressMode);
        return this;
    }

    /**
     * Gets the keypressMode.
     *
     * @return KeypressMode Desired keypress mode. If omitted, this value will be set to RESEND_CURRENT_ENTRY.
     */
    public KeypressMode getKeypressMode() {
        return (KeypressMode) getObject(KeypressMode.class, KEY_KEYPRESS_MODE);
    }

    /**
     * Sets the limitedCharacterList.
     *
     * @param limitedCharacterList Array of keyboard characters to enable.All omitted characters will be greyed out
     * (disabled) on the keyboard.If omitted, the entire keyboard will be enabled.
     * {"string_max_length": 1, "string_min_length": 1, "array_max_size": 100, "array_min_size": 1}
     */
    public KeyboardProperties setLimitedCharacterList(List<String> limitedCharacterList) {
        setValue(KEY_LIMITED_CHARACTER_LIST, limitedCharacterList);
        return this;
    }

    /**
     * Gets the limitedCharacterList.
     *
     * @return List<String> Array of keyboard characters to enable.All omitted characters will be greyed out
     * (disabled) on the keyboard.If omitted, the entire keyboard will be enabled.
     * {"string_max_length": 1, "string_min_length": 1, "array_max_size": 100, "array_min_size": 1}
     */
    @SuppressWarnings("unchecked")
    public List<String> getLimitedCharacterList() {
        return (List<String>) getObject(String.class, KEY_LIMITED_CHARACTER_LIST);
    }

    /**
     * Sets the autoCompleteText.
     *
     * @param autoCompleteText Deprecated, use autoCompleteList instead.
     * {"string_max_length": 1000, "string_min_length": 1}
     * @since SmartDeviceLink 3.0.0
     * @deprecated in SmartDeviceLink 6.0.0
     */
    @Deprecated
    public KeyboardProperties setAutoCompleteText(String autoCompleteText) {
        setValue(KEY_AUTO_COMPLETE_TEXT, autoCompleteText);
        return this;
    }

    /**
     * Gets the autoCompleteText.
     *
     * @return String Deprecated, use autoCompleteList instead.
     * {"string_max_length": 1000, "string_min_length": 1}
     * @since SmartDeviceLink 3.0.0
     * @deprecated in SmartDeviceLink 6.0.0
     */
    @Deprecated
    public String getAutoCompleteText() {
        return getString(KEY_AUTO_COMPLETE_TEXT);
    }

    /**
     * Sets the autoCompleteList.
     *
     * @param autoCompleteList Allows an app to pre-populate the text field with a list of suggested or completed entries
     * as the user types. If empty, the auto-complete list will be removed from the screen.
     * {"string_max_length": 1000, "string_min_length": 1, "array_max_size": 100, "array_min_size": 0}
     * @since SmartDeviceLink 6.0.0
     */
    public KeyboardProperties setAutoCompleteList(List<String> autoCompleteList) {
        setValue(KEY_AUTO_COMPLETE_LIST, autoCompleteList);
        return this;
    }

    /**
     * Gets the autoCompleteList.
     *
     * @return List<String> Allows an app to pre-populate the text field with a list of suggested or completed entries
     * as the user types. If empty, the auto-complete list will be removed from the screen.
     * {"string_max_length": 1000, "string_min_length": 1, "array_max_size": 100, "array_min_size": 0}
     * @since SmartDeviceLink 6.0.0
     */
    @SuppressWarnings("unchecked")
    public List<String> getAutoCompleteList() {
        return (List<String>) getObject(String.class, KEY_AUTO_COMPLETE_LIST);
    }

    /**
     * Sets the maskInputCharacters.
     *
     * @param maskInputCharacters Allows an app to mask entered characters on HMI
     * @since SmartDeviceLink 7.1.0
     */
    public KeyboardProperties setMaskInputCharacters(KeyboardInputMask maskInputCharacters) {
        setValue(KEY_MASK_INPUT_CHARACTERS, maskInputCharacters);
        return this;
    }

    /**
     * Gets the maskInputCharacters.
     *
     * @return KeyboardInputMask Allows an app to mask entered characters on HMI
     * @since SmartDeviceLink 7.1.0
     */
    public KeyboardInputMask getMaskInputCharacters() {
        return (KeyboardInputMask) getObject(KeyboardInputMask.class, KEY_MASK_INPUT_CHARACTERS);
    }

    /**
     * Sets the customKeys.
     *
     * @param customKeys Array of special characters to show in customizable keys. If omitted, keyboard will show
     * default special characters
     * {"string_max_length": 1, "string_min_length": 1, "array_max_size": 10, "array_min_size": 1}
     * @since SmartDeviceLink 7.1.0
     */
    public KeyboardProperties setCustomKeys(List<String> customKeys) {
        setValue(KEY_CUSTOM_KEYS, customKeys);
        return this;
    }

    /**
     * Gets the customKeys.
     *
     * @return List<String> Array of special characters to show in customizable keys. If omitted, keyboard will show
     * default special characters
     * {"string_max_length": 1, "string_min_length": 1, "array_max_size": 10, "array_min_size": 1}
     * @since SmartDeviceLink 7.1.0
     */
    @SuppressWarnings("unchecked")
    public List<String> getCustomKeys() {
        return (List<String>) getObject(String.class, KEY_CUSTOM_KEYS);
    }
}
