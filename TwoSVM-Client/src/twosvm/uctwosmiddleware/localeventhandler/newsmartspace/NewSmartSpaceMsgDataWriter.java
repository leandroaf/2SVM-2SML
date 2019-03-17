package twosvm.uctwosmiddleware.localeventhandler.newsmartspace;

import twosvm.uctwosmiddleware.eventhandler.newsmartspace.NewSmartSpaceMsg;

import com.toc.coredx.DDS.DataWriter;
import com.toc.coredx.DDS.InstanceHandle_t;
import com.toc.coredx.DDS.Publisher;
import com.toc.coredx.DDS.ReturnCode_t;
import com.toc.coredx.DDS.SWIGTYPE_p__DataWriter;
import com.toc.coredx.DDS.Time_t;
import com.toc.coredx.DDS.Topic;

public class NewSmartSpaceMsgDataWriter extends DataWriter {
	  
	  NewSmartSpaceMsgDataWriter (Publisher             p,
	                        Topic                 topic,
	                        SWIGTYPE_p__DataWriter j_dw) {
	     super(p,topic,j_dw);
	  }
	  public InstanceHandle_t register_instance(NewSmartSpaceMsg  instance_data) {
	    InstanceHandle_t retval =  _register_instance(instance_data);
	    return retval;
	  }
	  public InstanceHandle_t register_instance_w_timestamp(NewSmartSpaceMsg  instance_data, Time_t ts) {
	    InstanceHandle_t retval =  _register_instance_w_timestamp(instance_data, ts);
	    return retval;
	  }
	  public ReturnCode_t    unregister_instance(NewSmartSpaceMsg  instance_data,
				 InstanceHandle_t  handle) {
	    ReturnCode_t retval =  _unregister_instance(instance_data, handle);
	    return retval;
	  }
	  public ReturnCode_t    unregister_instance_w_timestamp(NewSmartSpaceMsg  instance_data,
				 InstanceHandle_t  handle,
	                        Time_t timestamp) {
	    ReturnCode_t retval =  _unregister_instance_w_timestamp(instance_data, handle, timestamp);
	    return retval;
	  }
	  public ReturnCode_t    write(NewSmartSpaceMsg  instance_data,
				 InstanceHandle_t  handle) {
	    ReturnCode_t retval =  _write(instance_data, handle);
	    return retval;
	  }
	  public ReturnCode_t    write_w_timestamp(NewSmartSpaceMsg  instance_data,
				 InstanceHandle_t  handle,
	                        Time_t timestamp) {
	    ReturnCode_t retval =  _write_w_timestamp(instance_data, handle, timestamp);
	    return retval;
	  }
	  public ReturnCode_t    dispose(NewSmartSpaceMsg  instance_data,
				 InstanceHandle_t  handle) {
	    ReturnCode_t retval =  _dispose(instance_data, handle);
	    return retval;
	  }
	  public ReturnCode_t    dispose_w_timestamp(NewSmartSpaceMsg  instance_data,
				 InstanceHandle_t  handle,
	                        Time_t timestamp) {
	    ReturnCode_t retval =  _dispose_w_timestamp(instance_data, handle, timestamp);
	    return retval;
	  }
	  public ReturnCode_t     get_key_value(NewSmartSpaceMsg                  key_holder,
	                                        InstanceHandle_t    handle) {
	    ReturnCode_t retval  = _get_key_value(key_holder, handle);
	    return retval;
	  }
	  public InstanceHandle_t lookup_instance(NewSmartSpaceMsg                  instance_data) {
	    InstanceHandle_t retval = _lookup_instance(instance_data);
	    return retval;
	  }
	}; // StringMsg
