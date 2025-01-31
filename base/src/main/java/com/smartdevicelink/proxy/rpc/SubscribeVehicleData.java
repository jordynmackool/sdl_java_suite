/*
 * Copyright (c) 2017 - 2019, SmartDeviceLink Consortium, Inc.
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
 * Neither the name of the SmartDeviceLink Consortium, Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
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

import com.smartdevicelink.protocol.enums.FunctionID;
import com.smartdevicelink.proxy.RPCRequest;

import java.util.Hashtable;

/**
 * Subscribes for specific published vehicle data items. The data will be only
 * sent, if it has changed. The application will be notified by the
 * onVehicleData notification whenever new data is available. The update rate is
 * very much dependent on sensors, vehicle architecture and vehicle type. Be
 * also prepared for the situation that a signal is not available on a vehicle
 *
 * <p>Function Group: Location, VehicleInfo and DrivingChara</p>
 *
 * <p><b>HMILevel needs to be FULL, LIMITED or BACKGROUND</b></p>
 *
 * <p><b>Parameter List</b></p>
 * <table border="1" rules="all">
 * 		<tr>
 * 			<th>Name</th>
 * 			<th>Type</th>
 * 			<th>Description</th>
 *                 <th>Reg.</th>
 *               <th>Notes</th>
 * 			<th>SmartDeviceLink Version</th>
 * 		</tr>
 * 		<tr>
 * 			<td>gps</td>
 * 			<td>Boolean</td>
 * 			<td>GPS data. See {@linkplain  GPSData}for details</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>speed</td>
 * 			<td>Boolean</td>
 * 			<td>The vehicle speed in kilometers per hour</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>rpm</td>
 * 			<td>Boolean</td>
 * 			<td>The number of revolutions per minute of the engine</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>fuelLevel</td>
 * 			<td>Boolean</td>
 * 			<td>The fuel level in the tank (percentage). This parameter is deprecated starting RPC Spec7.0, please see fuelRange.</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 7.0.0</td>
 * 		</tr>
 * 		<tr>
 * 			<td>fuelLevel_State</td>
 * 			<td>Boolean</td>
 * 			<td>The fuel level state. This parameter is deprecated starting RPC Spec 7.0, please see fuelRange.</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 7.0.0</td>
 * 		</tr>
 * 		<tr>
 * 			<td>fuelRange</td>
 * 			<td>Boolean</td>
 * 			<td>The fuel type, estimated range in KM, fuel level/capacity and fuel level state for the vehicle. See struct FuelRange for details.</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 5.0.0</td>
 * 		</tr>
 * 		<tr>
 * 			<td>instantFuelConsumption</td>
 * 			<td>Boolean</td>
 * 			<td>The instantaneous fuel consumption in micro litres</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>externalTemperature</td>
 * 			<td>Boolean</td>
 * 			<td>The external temperature in degrees celsius. This parameter is deprecated starting RPCSpec 7.1.0, please see climateData.</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>
 * 				SmartDeviceLink 2.0.0
 * 				@property-deprecated in SmartDeviceLink 7.1.0
 * 			</td>
 * 		</tr>
 *  	<tr>
 *      	<td>gearStatus</td>
 *      	<td>Boolean</td>
 *      	<td>See GearStatus</td>
 *      	<td>N</td>
 *      	<td>SmartDeviceLink 7.0.0</td>
 *  	</tr>
 *  	<tr>
 *     		<td>prndl</td>
 *      	<td>Boolean</td>
 *      	<td>See PRNDL. This parameter is deprecated and it is now covered in `gearStatus`</td>
 *      	<td>N</td>
 *      	<td>SmartDeviceLink 7.0.0</td>
 *  </tr>
 * 		<tr>
 * 			<td>tirePressure</td>
 * 			<td>Boolean</td>
 * 			<td>Tire pressure status</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>odometer</td>
 * 			<td>Boolean</td>
 * 			<td>Odometer in km</td>
 *                 <td>N</td>
 *                 <td>Max Length: 500</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>beltStatus</td>
 * 			<td>Boolean</td>
 * 			<td>The status of the seat belts</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>bodyInformation</td>
 * 			<td>Boolean</td>
 * 			<td>The body information including ignition status and internal temp</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>deviceStatus</td>
 * 			<td>Boolean</td>
 * 			<td>The device status including signal and battery strength</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>driverBraking</td>
 * 			<td>Boolean</td>
 * 			<td>The status of the brake pedal</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>wiperStatus</td>
 * 			<td>Boolean</td>
 * 			<td>The status of the wipers</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>headLampStatus</td>
 * 			<td>Boolean</td>
 * 			<td>Status of the head lamps</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>engineTorque</td>
 * 			<td>Boolean</td>
 * 			<td>Torque value for engine (in Nm) on non-diesel variants</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>engineOilLife</td>
 * 			<td>Boolean</td>
 * 			<td>The estimated percentage of remaining oil life of the engine</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 5.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>accPedalPosition</td>
 * 			<td>Boolean</td>
 * 			<td>Accelerator pedal position (percentage depressed)</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>steeringWheelAngle</td>
 * 			<td>Boolean</td>
 * 			<td>Current angle of the steering wheel (in deg)</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>eCallInfo</td>
 * 			<td>Boolean</td>
 * 			<td>Emergency Call notification and confirmation data.</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>airbagStatus</td>
 * 			<td>Boolean</td>
 * 			<td>The status of the air bags.</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>emergencyEvent</td>
 * 			<td>Boolean</td>
 * 			<td>Information related to an emergency event (and if it occurred).</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>clusterModeStatus</td>
 * 			<td>Boolean</td>
 * 			<td>The status modes of the instrument panel cluster.</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>myKey</td>
 * 			<td>Boolean</td>
 * 			<td>Information related to the MyKey feature.</td>
 *                 <td>N</td>
 *                 <td>Subscribable</td>
 * 			<td>SmartDeviceLink 2.0 </td>
 * 		</tr>
 * 		<tr>
 * 			<td>turnSignal</td>
 * 			<td>Boolean</td>
 * 			<td>@see TurnSignal</td>
 * 				<td>N</td>
 * 				<td>Subscribable</td>
 * 			<td>SmartDeviceLink 5.0 </td>
 * 		</tr>
 * 	     <tr>
 * 			<td>cloudAppVehicleID</td>
 * 			<td>Boolean</td>
 * 			<td>ID for the vehicle when connecting to cloud applications</td>
 * 				<td>N</td>
 * 				<td>Subscribable</td>
 * 			<td>SmartDeviceLink 5.1 </td>
 * 		</tr>
 *      <tr>
 *          <td>handsOffSteering</td>
 *          <td>Boolean</td>
 *          <td>To indicate whether driver hands are off the steering wheel</td>
 *          <td>N</td>
 *          <td>SmartDeviceLink 7.0.0</td>
 *      </tr>
 *      <tr>
 *          <td>windowStatus</td>
 *          <td>Boolean</td>
 *          <td>See WindowStatus</td>
 *          <td>N</td>
 *          <td>SmartDeviceLink 7.0.0</td>
 *      </tr>
 * 	    <tr>
 *        	<td>stabilityControlsStatus</td>
 * 		    <td>Boolean</td>
 * 		    <td>See StabilityControlsStatus</td>
 * 		    <td>N</td>
 * 		    <td>SmartDeviceLink 7.0.0</td>
 * 		</tr>
 *      <tr>
 *          <td>climateData</td>
 *          <td>Boolean</td>
 *          <td>See ClimateData</td>
 *          <td>N</td>
 *          <td></td>
 *          <td>
 *              SmartDeviceLink 7.1.0
 *          </td>
 *      </tr>
 * 		<tr>
 * 		    <td>seatOccupancy</td>
 * 		    <td>Boolean</td>
 * 		    <td>See SeatOccupancy</td>
 * 		    <td>N</td>
 * 		    <td></td>
 * 		    <td>
 * 		     SmartDeviceLink 7.1.0
 * 		    </td>
 * 		</tr>
 *   </table>
 *
 * <p> <b>Response</b></p>
 * <p><b>Non-default Result Codes:</b></p>
 * <p>SUCCESS</p>
 * <p>WARNINGS </p>
 * <p>INVALID_DATA</p>
 * 	<p>OUT_OF_MEMORY</p>
 * 	<p>TOO_MANY_PENDING_REQUESTS</p>
 * 	<p>APPLICATION_NOT_REGISTERED</p>
 * 	<p>GENERIC_ERROR</p>
 * 	<p>IGNORED </p>
 * 	<p>DISALLOWED</p>
 * 	<p>USER_DISALLOWED </p>
 *
 * @see UnsubscribeVehicleData
 * @see GetVehicleData
 *  SmartDeviceLink 2.0
 */
public class SubscribeVehicleData extends RPCRequest {
    public static final String KEY_RPM = "rpm";
    /**
     *  SmartDeviceLink 2.0.0
     * @deprecated in SmartDeviceLink 7.1.0
     */
    @Deprecated
    public static final String KEY_EXTERNAL_TEMPERATURE = "externalTemperature";
    public static final String KEY_PRNDL = "prndl";
    public static final String KEY_TIRE_PRESSURE = "tirePressure";
    public static final String KEY_ENGINE_TORQUE = "engineTorque";
    public static final String KEY_ENGINE_OIL_LIFE = "engineOilLife";
    public static final String KEY_ODOMETER = "odometer";
    public static final String KEY_GPS = "gps";
    public static final String KEY_INSTANT_FUEL_CONSUMPTION = "instantFuelConsumption";
    public static final String KEY_BELT_STATUS = "beltStatus";
    public static final String KEY_BODY_INFORMATION = "bodyInformation";
    public static final String KEY_DEVICE_STATUS = "deviceStatus";
    public static final String KEY_DRIVER_BRAKING = "driverBraking";
    public static final String KEY_WIPER_STATUS = "wiperStatus";
    public static final String KEY_HEAD_LAMP_STATUS = "headLampStatus";
    public static final String KEY_ACC_PEDAL_POSITION = "accPedalPosition";
    public static final String KEY_STEERING_WHEEL_ANGLE = "steeringWheelAngle";
    public static final String KEY_E_CALL_INFO = "eCallInfo";
    public static final String KEY_AIRBAG_STATUS = "airbagStatus";
    public static final String KEY_EMERGENCY_EVENT = "emergencyEvent";
    public static final String KEY_CLUSTER_MODE_STATUS = "clusterModeStatus";
    public static final String KEY_MY_KEY = "myKey";
    public static final String KEY_SPEED = "speed";
    public static final String KEY_FUEL_RANGE = "fuelRange";
    public static final String KEY_TURN_SIGNAL = "turnSignal";
    public static final String KEY_ELECTRONIC_PARK_BRAKE_STATUS = "electronicParkBrakeStatus";
    public static final String KEY_CLOUD_APP_VEHICLE_ID = "cloudAppVehicleID";
    public static final String KEY_HANDS_OFF_STEERING = "handsOffSteering";
    public static final String KEY_WINDOW_STATUS = "windowStatus";
    public static final String KEY_GEAR_STATUS = "gearStatus";
    /**
     * @deprecated
     */
    @Deprecated
    public static final String KEY_FUEL_LEVEL = "fuelLevel";
    /**
     * @deprecated
     */
    @Deprecated
    public static final String KEY_FUEL_LEVEL_STATE = "fuelLevel_State";
    public static final String KEY_STABILITY_CONTROLS_STATUS = "stabilityControlsStatus";
    /**
     *  SmartDeviceLink 7.1.0
     */
    public static final String KEY_CLIMATE_DATA = "climateData";
    /**
     *  SmartDeviceLink 7.1.0
     */
    public static final String KEY_SEAT_OCCUPANCY = "seatOccupancy";

    /**
     * Constructs a new SubscribeVehicleData object
     */
    public SubscribeVehicleData() {
        super(FunctionID.SUBSCRIBE_VEHICLE_DATA.toString());
    }

    /**
     * <p>Constructs a new SubscribeVehicleData object indicated by the Hashtable
     * parameter</p>
     *
     * @param hash The Hashtable to use
     */
    public SubscribeVehicleData(Hashtable<String, Object> hash) {
        super(hash);
    }

    /**
     * Sets a boolean value. If true, subscribes Gps data
     *
     * @param gps a boolean value
     */
    public SubscribeVehicleData setGps(Boolean gps) {
        setParameters(KEY_GPS, gps);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the Gps data has been subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the Gps data has been
     * subscribed.
     */
    public Boolean getGps() {
        return getBoolean(KEY_GPS);
    }

    /**
     * Sets a boolean value. If true, subscribes speed data
     *
     * @param speed a boolean value
     */
    public SubscribeVehicleData setSpeed(Boolean speed) {
        setParameters(KEY_SPEED, speed);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the Speed data has been subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the Speed data has been
     * subscribed.
     */
    public Boolean getSpeed() {
        return getBoolean(KEY_SPEED);
    }

    /**
     * Sets a boolean value. If true, subscribes rpm data
     *
     * @param rpm a boolean value
     */
    public SubscribeVehicleData setRpm(Boolean rpm) {
        setParameters(KEY_RPM, rpm);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the rpm data has been subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the rpm data has been
     * subscribed.
     */
    public Boolean getRpm() {
        return getBoolean(KEY_RPM);
    }

    /**
     * Sets the fuelLevel.
     *
     * @param fuelLevel The fuel level in the tank (percentage). This parameter is deprecated starting RPC Spec
     *                  7.0, please see fuelRange.
     */
    @Deprecated
    public SubscribeVehicleData setFuelLevel(Boolean fuelLevel) {
        setParameters(KEY_FUEL_LEVEL, fuelLevel);
        return this;
    }

    /**
     * Gets the fuelLevel.
     *
     * @return Float The fuel level in the tank (percentage). This parameter is deprecated starting RPC Spec
     * 7.0, please see fuelRange.
     */
    @Deprecated
    public Boolean getFuelLevel() {
        return getBoolean(KEY_FUEL_LEVEL);
    }

    /**
     * Sets a boolean value. If true, subscribes fuelLevelState data
     *
     * @param fuelLevelState a boolean value
     */
    @Deprecated
    public SubscribeVehicleData setFuelLevelState(Boolean fuelLevelState) {
        setParameters(KEY_FUEL_LEVEL_STATE, fuelLevelState);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the fuelLevelState data has been
     * subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the fuelLevelState data
     * has been subscribed.
     */
    @Deprecated
    public Boolean getFuelLevelState() {
        return getBoolean(KEY_FUEL_LEVEL_STATE);
    }

    /**
     * Sets a boolean value. If true, subscribes instantFuelConsumption data
     *
     * @param instantFuelConsumption a boolean value
     */
    public SubscribeVehicleData setInstantFuelConsumption(Boolean instantFuelConsumption) {
        setParameters(KEY_INSTANT_FUEL_CONSUMPTION, instantFuelConsumption);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the getInstantFuelConsumption data has been
     * subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the getInstantFuelConsumption data
     * has been subscribed.
     */
    public Boolean getInstantFuelConsumption() {
        return getBoolean(KEY_INSTANT_FUEL_CONSUMPTION);
    }

    /**
     * Sets the externalTemperature.
     *
     * @param externalTemperature The external temperature in degrees celsius. This parameter is deprecated starting RPC
     * Spec 7.1.0, please see climateData.
     *  SmartDeviceLink 2.0.0
     * @deprecated in SmartDeviceLink 7.1.0
     */
    @Deprecated
    public SubscribeVehicleData setExternalTemperature(Boolean externalTemperature) {
        setParameters(KEY_EXTERNAL_TEMPERATURE, externalTemperature);
        return this;
    }

    /**
     * Gets the externalTemperature.
     *
     * @return Boolean The external temperature in degrees celsius. This parameter is deprecated starting RPC
     * Spec 7.1.0, please see climateData.
     *  SmartDeviceLink 2.0.0
     * @deprecated in SmartDeviceLink 7.1.0
     */
    @Deprecated
    public Boolean getExternalTemperature() {
        return getBoolean(KEY_EXTERNAL_TEMPERATURE);
    }

    /**
     * Sets the gearStatus.
     *
     * @param gearStatus See GearStatus
     *  SmartDeviceLink 7.0.0
     */
    public SubscribeVehicleData setGearStatus(Boolean gearStatus) {
        setParameters(KEY_GEAR_STATUS, gearStatus);
        return this;
    }

    /**
     * Gets the gearStatus.
     *
     * @return Boolean See GearStatus
     *  SmartDeviceLink 7.0.0
     */
    public Boolean getGearStatus() {
        return getBoolean(KEY_GEAR_STATUS);
    }

    /**
     * Sets the prndl.
     *
     * @param prndl See PRNDL. This parameter is deprecated since 7.0.0 and it is now covered in `gearStatus`
     * @deprecated in SmartDeviceLink 7.0.0
     */
    @Deprecated
    public SubscribeVehicleData setPrndl(Boolean prndl) {
        setParameters(KEY_PRNDL, prndl);
        return this;
    }

    /**
     * Gets the prndl.
     *
     * @return Boolean See PRNDL. This parameter is deprecated since 7.0.0 and it is now covered in `gearStatus`
     * @deprecated in SmartDeviceLink 7.0.0
     */
    @Deprecated
    public Boolean getPrndl() {
        return getBoolean(KEY_PRNDL);
    }

    /**
     * Sets a boolean value. If true, subscribes tire pressure status data
     *
     * @param tirePressure a boolean value
     */
    public SubscribeVehicleData setTirePressure(Boolean tirePressure) {
        setParameters(KEY_TIRE_PRESSURE, tirePressure);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the tire pressure status data has been
     * subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the tire pressure status data
     * has been subscribed.
     */
    public Boolean getTirePressure() {
        return getBoolean(KEY_TIRE_PRESSURE);
    }

    /**
     * Sets a boolean value. If true, subscribes odometer data
     *
     * @param odometer a boolean value
     */
    public SubscribeVehicleData setOdometer(Boolean odometer) {
        setParameters(KEY_ODOMETER, odometer);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the odometer data has been
     * subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the odometer data
     * has been subscribed.
     */
    public Boolean getOdometer() {
        return getBoolean(KEY_ODOMETER);
    }

    /**
     * Sets a boolean value. If true, subscribes belt Status data
     *
     * @param beltStatus a boolean value
     */
    public SubscribeVehicleData setBeltStatus(Boolean beltStatus) {
        setParameters(KEY_BELT_STATUS, beltStatus);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the belt Status data has been
     * subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the belt Status data
     * has been subscribed.
     */
    public Boolean getBeltStatus() {
        return getBoolean(KEY_BELT_STATUS);
    }

    /**
     * Sets a boolean value. If true, subscribes body Information data
     *
     * @param bodyInformation a boolean value
     */
    public SubscribeVehicleData setBodyInformation(Boolean bodyInformation) {
        setParameters(KEY_BODY_INFORMATION, bodyInformation);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the body Information data has been
     * subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the body Information data
     * has been subscribed.
     */
    public Boolean getBodyInformation() {
        return getBoolean(KEY_BODY_INFORMATION);
    }

    /**
     * Sets a boolean value. If true, subscribes device Status data
     *
     * @param deviceStatus a boolean value
     */
    public SubscribeVehicleData setDeviceStatus(Boolean deviceStatus) {
        setParameters(KEY_DEVICE_STATUS, deviceStatus);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the device Status data has been
     * subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the device Status data
     * has been subscribed.
     */
    public Boolean getDeviceStatus() {
        return getBoolean(KEY_DEVICE_STATUS);
    }

    /**
     * Sets a boolean value. If true, subscribes driver Braking data
     *
     * @param driverBraking a boolean value
     */
    public SubscribeVehicleData setDriverBraking(Boolean driverBraking) {
        setParameters(KEY_DRIVER_BRAKING, driverBraking);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the driver Braking data has been
     * subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the driver Braking data
     * has been subscribed.
     */
    public Boolean getDriverBraking() {
        return getBoolean(KEY_DRIVER_BRAKING);
    }

    /**
     * Sets a boolean value. If true, subscribes wiper Status data
     *
     * @param wiperStatus a boolean value
     */
    public SubscribeVehicleData setWiperStatus(Boolean wiperStatus) {
        setParameters(KEY_WIPER_STATUS, wiperStatus);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the wiper Status data has been
     * subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the wiper Status data
     * has been subscribed.
     */
    public Boolean getWiperStatus() {
        return getBoolean(KEY_WIPER_STATUS);
    }

    /**
     * Sets a boolean value. If true, subscribes Head Lamp Status data
     *
     * @param headLampStatus a boolean value
     */
    public SubscribeVehicleData setHeadLampStatus(Boolean headLampStatus) {
        setParameters(KEY_HEAD_LAMP_STATUS, headLampStatus);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the Head Lamp Status data has been
     * subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the Head Lamp Status data
     * has been subscribed.
     */
    public Boolean getHeadLampStatus() {
        return getBoolean(KEY_HEAD_LAMP_STATUS);
    }

    /**
     * Sets a boolean value. If true, subscribes Engine Torque data
     *
     * @param engineTorque a boolean value
     */
    public SubscribeVehicleData setEngineTorque(Boolean engineTorque) {
        setParameters(KEY_ENGINE_TORQUE, engineTorque);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the Engine Oil Life data has been
     * subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the Engine Oil Life data
     * has been subscribed.
     */
    public Boolean getEngineOilLife() {
        return getBoolean(KEY_ENGINE_OIL_LIFE);
    }

    /**
     * Sets a boolean value. If true, subscribes Engine Oil Life data
     *
     * @param engineOilLife a boolean value
     */
    public SubscribeVehicleData setEngineOilLife(Boolean engineOilLife) {
        setParameters(KEY_ENGINE_OIL_LIFE, engineOilLife);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the Engine Torque data has been
     * subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the Engine Torque data
     * has been subscribed.
     */
    public Boolean getEngineTorque() {
        return getBoolean(KEY_ENGINE_TORQUE);
    }

    /**
     * Sets a boolean value. If true, subscribes accPedalPosition data
     *
     * @param accPedalPosition a boolean value
     */
    public SubscribeVehicleData setAccPedalPosition(Boolean accPedalPosition) {
        setParameters(KEY_ACC_PEDAL_POSITION, accPedalPosition);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the accPedalPosition data has been
     * subscribed.
     *
     * @return Boolean -a Boolean value. If true, means the accPedalPosition data
     * has been subscribed.
     */
    public Boolean getAccPedalPosition() {
        return getBoolean(KEY_ACC_PEDAL_POSITION);
    }

    public SubscribeVehicleData setSteeringWheelAngle(Boolean steeringWheelAngle) {
        setParameters(KEY_STEERING_WHEEL_ANGLE, steeringWheelAngle);
        return this;
    }

    public Boolean getSteeringWheelAngle() {
        return getBoolean(KEY_STEERING_WHEEL_ANGLE);
    }

    public SubscribeVehicleData setECallInfo(Boolean eCallInfo) {
        setParameters(KEY_E_CALL_INFO, eCallInfo);
        return this;
    }

    public Boolean getECallInfo() {
        return getBoolean(KEY_E_CALL_INFO);
    }

    public SubscribeVehicleData setAirbagStatus(Boolean airbagStatus) {
        setParameters(KEY_AIRBAG_STATUS, airbagStatus);
        return this;
    }

    public Boolean getAirbagStatus() {
        return getBoolean(KEY_AIRBAG_STATUS);
    }

    public SubscribeVehicleData setEmergencyEvent(Boolean emergencyEvent) {
        setParameters(KEY_EMERGENCY_EVENT, emergencyEvent);
        return this;
    }

    public Boolean getEmergencyEvent() {
        return getBoolean(KEY_EMERGENCY_EVENT);
    }

    public SubscribeVehicleData setClusterModeStatus(Boolean clusterModeStatus) {
        setParameters(KEY_CLUSTER_MODE_STATUS, clusterModeStatus);
        return this;
    }

    public Boolean getClusterModeStatus() {
        return getBoolean(KEY_CLUSTER_MODE_STATUS);
    }

    public SubscribeVehicleData setMyKey(Boolean myKey) {
        setParameters(KEY_MY_KEY, myKey);
        return this;
    }

    public Boolean getMyKey() {
        return getBoolean(KEY_MY_KEY);
    }

    /**
     * Sets the fuelRange.
     *
     * @param fuelRange The fuel type, estimated range in KM, fuel level/capacity and fuel level state for the
     *                  vehicle. See struct FuelRange for details.
     *  SmartDeviceLink 5.0.0
     */
    public SubscribeVehicleData setFuelRange(Boolean fuelRange) {
        setParameters(KEY_FUEL_RANGE, fuelRange);
        return this;
    }

    /**
     * Gets the fuelRange.
     *
     * @return Boolean The fuel type, estimated range in KM, fuel level/capacity and fuel level state for the
     * vehicle. See struct FuelRange for details.
     *  SmartDeviceLink 5.0.0
     */
    public Boolean getFuelRange() {
        return getBoolean(KEY_FUEL_RANGE);
    }

    /**
     * Sets a boolean value. If true, subscribes turnSignal data
     *
     * @param turnSignal a boolean value
     */
    public SubscribeVehicleData setTurnSignal(Boolean turnSignal) {
        setParameters(KEY_TURN_SIGNAL, turnSignal);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the turnSignal data has been subscribed.
     *
     * @return a Boolean value.
     */
    public Boolean getTurnSignal() {
        return getBoolean(KEY_TURN_SIGNAL);
    }

    /**
     * Sets a boolean value. If true, subscribes electronicParkBrakeStatus data
     *
     * @param electronicParkBrakeStatus a boolean value
     */
    public SubscribeVehicleData setElectronicParkBrakeStatus(boolean electronicParkBrakeStatus) {
        setParameters(KEY_ELECTRONIC_PARK_BRAKE_STATUS, electronicParkBrakeStatus);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the electronicParkBrakeStatus data has been subscribed.
     *
     * @return a Boolean value.
     */
    public Boolean getElectronicParkBrakeStatus() {
        return getBoolean(KEY_ELECTRONIC_PARK_BRAKE_STATUS);
    }

    /**
     * Sets a boolean value. If true, subscribes cloudAppVehicleID data
     *
     * @param cloudAppVehicleID a boolean value
     */
    public SubscribeVehicleData setCloudAppVehicleID(boolean cloudAppVehicleID) {
        setParameters(KEY_CLOUD_APP_VEHICLE_ID, cloudAppVehicleID);
        return this;
    }

    /**
     * Gets a boolean value. If true, means the cloudAppVehicleDataID data has been subscribed.
     *
     * @return a Boolean value.
     */
    public Boolean getCloudAppVehicleID() {
        return getBoolean(KEY_CLOUD_APP_VEHICLE_ID);
    }

    /**
     * Sets a boolean value for OEM Custom VehicleData.
     *
     * @param vehicleDataName  a String value
     * @param vehicleDataState a boolean value
     */
    public SubscribeVehicleData setOEMCustomVehicleData(String vehicleDataName, Boolean vehicleDataState) {
        setParameters(vehicleDataName, vehicleDataState);
        return this;
    }

    /**
     * Gets a boolean value for OEM Custom VehicleData.
     *
     * @return a Boolean value.
     */
    public Boolean getOEMCustomVehicleData(String vehicleDataName) {
        return getBoolean(vehicleDataName);
    }

    /**
     * Sets the windowStatus.
     *
     * @param windowStatus See WindowStatus
     *  SmartDeviceLink 7.0.0
     */
    public SubscribeVehicleData setWindowStatus(Boolean windowStatus) {
        setParameters(KEY_WINDOW_STATUS, windowStatus);
        return this;
    }

    /**
     * Gets the windowStatus.
     *
     * @return Boolean See WindowStatus
     *  SmartDeviceLink 7.0.0
     */
    public Boolean getWindowStatus() {
        return getBoolean(KEY_WINDOW_STATUS);
    }

    /**
     * Sets the handsOffSteering.
     *
     * @param handsOffSteering To indicate whether driver hands are off the steering wheel
     *  SmartDeviceLink 7.0.0
     */
    public SubscribeVehicleData setHandsOffSteering(Boolean handsOffSteering) {
        setParameters(KEY_HANDS_OFF_STEERING, handsOffSteering);
        return this;
    }

    /**
     * Gets the handsOffSteering.
     *
     * @return Boolean To indicate whether driver hands are off the steering wheel
     *  SmartDeviceLink 7.0.0
     */
    public Boolean getHandsOffSteering() {
        return getBoolean(KEY_HANDS_OFF_STEERING);
    }

    /**
     * Gets the stabilityControlsStatus.
     *
     * @return Boolean See StabilityControlsStatus
     *  SmartDeviceLink 7.0.0
     */
    public Boolean getStabilityControlsStatus() {
        return getBoolean(KEY_STABILITY_CONTROLS_STATUS);
    }

    /**
     * Sets the stabilityControlsStatus.
     *
     * @param stabilityControlsStatus See StabilityControlsStatus
     *  SmartDeviceLink 7.0.0
     */
    public SubscribeVehicleData setStabilityControlsStatus(Boolean stabilityControlsStatus) {
        setParameters(KEY_STABILITY_CONTROLS_STATUS, stabilityControlsStatus);
        return this;
    }

    /**
     * Sets the climateData.
     *
     * @param climateData See ClimateData
     *  SmartDeviceLink 7.1.0
     */
    public SubscribeVehicleData setClimateData(Boolean climateData) {
        setParameters(KEY_CLIMATE_DATA, climateData);
        return this;
    }

    /**
     * Gets the climateData.
     *
     * @return Boolean See ClimateData
     *  SmartDeviceLink 7.1.0
     */
    public Boolean getClimateData() {
        return getBoolean(KEY_CLIMATE_DATA);
    }

    /**
     * Sets the seatOccupancy.
     *
     * @param seatOccupancy See SeatOccupancy
     *  SmartDeviceLink 7.1.0
     */
    public SubscribeVehicleData setSeatOccupancy(Boolean seatOccupancy) {
        setParameters(KEY_SEAT_OCCUPANCY, seatOccupancy);
        return this;
    }

    /**
     * Gets the seatOccupancy.
     *
     * @return Boolean See SeatOccupancy
     *  SmartDeviceLink 7.1.0
     */
    public Boolean getSeatOccupancy() {
        return getBoolean(KEY_SEAT_OCCUPANCY);
    }
}
