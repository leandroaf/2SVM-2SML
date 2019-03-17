package twosvm.uctwosmiddleware.localeventhandler.ubiquitousapplication;

// CoreDX DDL Generated code.  Do not modify - modifications may be overwritten.
import com.toc.coredx.DDS.*;

public class UbiAppMsgDataWriter extends DataWriter {

	UbiAppMsgDataWriter(Publisher p, Topic topic, SWIGTYPE_p__DataWriter j_dw) {
		super(p, topic, j_dw);
	}

	public InstanceHandle_t register_instance(UbiAppMsg instance_data) {
		InstanceHandle_t retval = _register_instance(instance_data);
		return retval;
	}

	public InstanceHandle_t register_instance_w_timestamp(
			UbiAppMsg instance_data, Time_t ts) {
		InstanceHandle_t retval = _register_instance_w_timestamp(instance_data,
				ts);
		return retval;
	}

	public ReturnCode_t unregister_instance(UbiAppMsg instance_data,
			InstanceHandle_t handle) {
		ReturnCode_t retval = _unregister_instance(instance_data, handle);
		return retval;
	}

	public ReturnCode_t unregister_instance_w_timestamp(UbiAppMsg instance_data,
			InstanceHandle_t handle, Time_t timestamp) {
		ReturnCode_t retval = _unregister_instance_w_timestamp(instance_data,
				handle, timestamp);
		return retval;
	}

	public ReturnCode_t write(UbiAppMsg instance_data, InstanceHandle_t handle) {
		ReturnCode_t retval = _write(instance_data, handle);
		return retval;
	}

	public ReturnCode_t write_w_timestamp(UbiAppMsg instance_data,
			InstanceHandle_t handle, Time_t timestamp) {
		ReturnCode_t retval = _write_w_timestamp(instance_data, handle,
				timestamp);
		return retval;
	}

	public ReturnCode_t dispose(UbiAppMsg instance_data, InstanceHandle_t handle) {
		ReturnCode_t retval = _dispose(instance_data, handle);
		return retval;
	}

	public ReturnCode_t dispose_w_timestamp(UbiAppMsg instance_data,
			InstanceHandle_t handle, Time_t timestamp) {
		ReturnCode_t retval = _dispose_w_timestamp(instance_data, handle,
				timestamp);
		return retval;
	}

	public ReturnCode_t get_key_value(UbiAppMsg key_holder,
			InstanceHandle_t handle) {
		ReturnCode_t retval = _get_key_value(key_holder, handle);
		return retval;
	}

	public InstanceHandle_t lookup_instance(UbiAppMsg instance_data) {
		InstanceHandle_t retval = _lookup_instance(instance_data);
		return retval;
	}
}; // StringMsg
