package twosvm.uctwosmiddleware.localeventhandler.ubiquitousapplication;

// CoreDX DDL Generated code.  Do not modify - modifications may be overwritten.
import com.toc.coredx.DDS.*;

import java.nio.*;
import java.nio.charset.*;

public final class UbiAppMsgTypeSupport implements TypeSupport {

	public ReturnCode_t register_type(DomainParticipant dp, String type_name) {
		if (dp.check_version("3", "6", "21") != 0) {
			System.out
					.println("WARNING: StringMsg TypeSupport version does not match CoreDX Library version.");
			System.out
					.println("This may cause software instability or crashes.");
		}
		return dp.register_type(this, type_name);
	}

	public String get_type_name() {
		return "PolicyMsg";
	}

	public long getCTypeSupport() {
		return cTypeSupport;
	}

	public UbiAppMsgTypeSupport() {
		UbiAppMsg tmp = new UbiAppMsg();
		cTypeSupport = DomainParticipant.createTypeSupport(this, getClass()
				.getName(), tmp.getClass().getName());
	}

	// ------------------------------------------------------
	// implementation

	public DataReader create_datareader(Subscriber sub, TopicDescription td,
			SWIGTYPE_p__DataReader jni_dr) {
		return new UbiAppMsgDataReader(sub, td, jni_dr);
	}

	public DataWriter create_datawriter(Publisher pub, Topic topic,
			SWIGTYPE_p__DataWriter jni_dw) {
		return new UbiAppMsgDataWriter(pub, topic, jni_dw);
	}

	// marshal variants
	public int marshall(ByteBuffer out_stream, UbiAppMsg src) {
		int size = 0;
		if (out_stream == null) {
			size = marshal_size_core(out_stream, size, src);
			size += 4; // for CDR 'header'
		} else {
			int offset = 0;
			out_stream.clear();
			if ((1 & 0x01) == 0)
				out_stream.order(ByteOrder.BIG_ENDIAN);
			else
				out_stream.order(ByteOrder.LITTLE_ENDIAN);

			// add CDR 'header'
			out_stream.put((byte) 0x00);
			out_stream.put((byte) 1);
			out_stream.put((byte) 0x00); // flags
			out_stream.put((byte) 0x00); // flags

			marshal_core(out_stream, offset, src);
			size = out_stream.position();
		}
		return size;
	}

	public int marshal_size_core(ByteBuffer out_stream, int size, UbiAppMsg src) {
		// src.eventName
		size = (size + 3) & 0xfffffffc;// align 4
		size += 4; // length
		if (src.eventName == null)
			size += 1;
		else {
			try {
				byte[] sbytes = src.eventName.getBytes("UTF-8");
				size += sbytes.length + 1;
			} catch (Exception e) {
				size += 1;
			}
		}
		
		// src.eventDescription
		size = (size + 3) & 0xfffffffc;// align 4
		size += 4; // length
		if (src.userLocationSS == null)
			size += 1;
		else {
			try {
				byte[] sbytes = src.userLocationSS.getBytes("UTF-8");
				size += sbytes.length + 1;
			} catch (Exception e) {
				size += 1;
			}
		}
		
	    // src.policyName
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.devLocationSS == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.devLocationSS.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.userRole
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.userTypeSS == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.userTypeSS.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.user
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.userNameSS == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.userNameSS.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.ubiApp
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.appTypeSS == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.appTypeSS.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.application
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.appNameSS == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.appNameSS.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.smartObject
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.deviceTypeSS == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.deviceTypeSS.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.device
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.deviceNameSS == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.deviceNameSS.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.deviceID
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.deviceID == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.deviceID.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.deviceIP
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.deviceIP == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.deviceIP.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.userID
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.userID == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.userID.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.appID
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.appID == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.appID.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.noiseLevel
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.noiseLevel == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.noiseLevel.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.temperature
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.temperature == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.temperature.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.humidity
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.humidity == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.humidity.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.lightLevel
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.lightLevel == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.lightLevel.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.smokeDetector
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.smokeDetector == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.smokeDetector.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.time
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.time == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.time.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.batteryLevel
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.batteryLevel == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.batteryLevel.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.userPressureLevel
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.userPressureLevel == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.userPressureLevel.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    // src.heartRate
	    size = (size+3) & 0xfffffffc;// align 4
	    size += 4; // length
	    if (src.heartRate == null) size += 1;
	    else {
	      try {
	        byte[] sbytes = src.heartRate.getBytes("UTF-8");
	        size += sbytes.length + 1;
	      } catch(Exception e) {
	        size += 1;
	      }
	    }
	    
	    return size;
	}

	public int marshal_core(ByteBuffer out_stream, int offset, UbiAppMsg src) {
		
		// src.eventName
		while ((offset & 0x03) != 0) {
			offset++;
			out_stream.put((byte) 0x00);
		} // align 4
		if (src.eventName == null) {
			out_stream.putInt(1);
		} else {
			try {
				byte[] sbytes = src.eventName.getBytes("UTF-8");
				out_stream.putInt(sbytes.length + 1);
				out_stream.put(sbytes);
				offset += sbytes.length;
			} catch (Exception e) {
				out_stream.putInt(1);
			}
		}
		out_stream.put((byte) 0);
		offset += 4 + 1;

		// src.eventDescription
		while ((offset & 0x03) != 0) {
			offset++;
			out_stream.put((byte) 0x00);
		} // align 4
		if (src.userLocationSS == null) {
			out_stream.putInt(1);
		} else {
			try {
				byte[] sbytes = src.userLocationSS.getBytes("UTF-8");
				out_stream.putInt(sbytes.length + 1);
				out_stream.put(sbytes);
				offset += sbytes.length;
			} catch (Exception e) {
				out_stream.putInt(1);
			}
		}
		out_stream.put((byte) 0);
		offset += 4 + 1;
		
		// src.policyName
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.devLocationSS == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.devLocationSS.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.userRole
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.userTypeSS == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.userTypeSS.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
		
		// src.user
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.userNameSS == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.userNameSS.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.ubiApp
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.appTypeSS == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.appTypeSS.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.application
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.appNameSS == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.appNameSS.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.smartObject
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.deviceTypeSS == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.deviceTypeSS.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.device
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.deviceNameSS == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.deviceNameSS.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.deviceID
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.deviceID == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.deviceID.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.deviceIP
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.deviceIP == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.deviceIP.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.userID
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.userID == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.userID.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.appID
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.appID == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.appID.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.noiseLevel
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.noiseLevel == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.noiseLevel.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.temperature
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.temperature == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.temperature.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.humidity
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.humidity == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.humidity.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.lightLevel
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.lightLevel == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.lightLevel.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.smokeDetector
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.smokeDetector == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.smokeDetector.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.time
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.time == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.time.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.batteryLevel
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.batteryLevel == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.batteryLevel.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.userPressureLevel
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.userPressureLevel == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.userPressureLevel.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		// src.heartRate
	    while((offset & 0x03) != 0) { offset++; out_stream.put((byte)0x00); } // align 4
	    if (src.heartRate == null) {
	     out_stream.putInt(1);
	    }
	    else {
	      try {
	        byte[] sbytes = src.heartRate.getBytes("UTF-8");
	        out_stream.putInt(sbytes.length+1);
	        out_stream.put(sbytes);
	        offset += sbytes.length;
	      } catch(Exception e) {
	        out_stream.putInt(1);
	      }
	    }
	    out_stream.put((byte)0);
	    offset += 4 + 1;
	    
		return offset;
	}

	public int marshall_fixed_size() {
		return 0;
	}

	public int marshall_key(ByteBuffer out_stream, UbiAppMsg src) {
		int size = 0;
		if (out_stream == null) {
			size += 4; // for CDR 'header'
		} else {
			int offset = 0;
			out_stream.clear();
			if ((1 & 0x01) == 0)
				out_stream.order(ByteOrder.BIG_ENDIAN);
			else
				out_stream.order(ByteOrder.LITTLE_ENDIAN);

			// add CDR 'header'
			out_stream.put((byte) 0x00);
			out_stream.put((byte) 1);
			out_stream.put((byte) 0x00); // flags
			out_stream.put((byte) 0x00); // flags

			size = out_stream.position();
		}
		return size;
	}

	public int marshall_key_hash(ByteBuffer out_stream, UbiAppMsg src) {
		int size = 0;
		if (out_stream == null) {
		} else {
			int offset = 0;
			out_stream.clear();
			out_stream.order(ByteOrder.BIG_ENDIAN);

			size = out_stream.position();
		}
		return size;
	}

	public boolean key_must_hash() {
		return false;
	}

	// unmarshal variants
	public int unmarshall(UbiAppMsg t, ByteBuffer data, int s) {
		int offset = 0;
		data.get(); // skip the first byte
		byte encoding = data.get(); // data encoding CDR / ENDIAN
		data.getShort(); // unused flags (2 bytes)
		if ((encoding & 0x01) == 0)
			data.order(ByteOrder.BIG_ENDIAN);
		else
			data.order(ByteOrder.LITTLE_ENDIAN);

		if ((encoding & 0xFE) == 0) { // CDR encoding
			unmarshal_core(t, data, offset, s);
		}
		
		return 1; // 1==success
	}

	public int unmarshal_core(UbiAppMsg t, ByteBuffer data, int offset, int s) {
		// t.eventName
		{
			while ((offset & 0x03) != 0) {
				offset++;
				data.position(data.position() + 1);
			}// align 4
			int slen = data.getInt() - 1; // skip trailing null
			byte[] sbytes = new byte[slen];
			data.get(sbytes, 0, slen);
			data.get(); // skip trailing null
			try {
				;
				t.eventName = new String(sbytes, "UTF-8");
			} catch (java.io.UnsupportedEncodingException e) {
				t.eventName = new String();
			}
			offset += 4 + slen + 1;
		}
		
		// t.eventDescription
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.userLocationSS   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.userLocationSS   = new String(); }
	      offset += 4 + slen + 1;
	    }
		
	    // t.devLocation
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.devLocationSS   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.devLocationSS   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.userType
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.userTypeSS   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.userTypeSS   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.userNameSS
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.userNameSS   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.userNameSS   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.appType
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.appTypeSS   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.appTypeSS   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.applicationName
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.appNameSS   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.appNameSS   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.deviceType
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.deviceTypeSS   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.deviceTypeSS   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.deviceName
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.deviceNameSS   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.deviceNameSS   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.deviceID
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.deviceID   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.deviceID   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.deviceIP
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.deviceIP   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.deviceIP   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.userID
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.userID   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.userID   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.appID
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.appID   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.appID   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.noiseLevel
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.noiseLevel   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.noiseLevel   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.temperature
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.temperature   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.temperature   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.humidity
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.humidity   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.humidity   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.lightLevel
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.lightLevel   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.lightLevel   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.smokeDetector
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.smokeDetector   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.smokeDetector   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.time
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.time   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.time   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.batteryLevel
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.batteryLevel   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.batteryLevel   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.userPressureLevel
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.userPressureLevel   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.userPressureLevel   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
	    // t.heartRate
	    {
	      while((offset & 0x03) != 0) { offset++; data.position(data.position()+1); }// align 4
	      int    slen   = data.getInt()-1;  // skip trailing null
	      byte[] sbytes = new byte[slen];
	      data.get(sbytes, 0, slen);
	      data.get(); // skip trailing null
	      try {;
	        t.heartRate   = new String(sbytes, "UTF-8");
	      } catch(java.io.UnsupportedEncodingException e) {
	        t.heartRate   = new String(); }
	      offset += 4 + slen + 1;
	    }
	    
		return offset; // >0==success
	}

	public int unmarshall_key(UbiAppMsg t, ByteBuffer data, int s) {
		int offset = 0;
		data.get(); // skip the first byte
		byte encoding = data.get(); // data encoding CDR / ENDIAN
		data.getShort(); // unused flags (2 bytes)
		if ((encoding & 0x01) == 0)
			data.order(ByteOrder.BIG_ENDIAN);
		else
			data.order(ByteOrder.LITTLE_ENDIAN);

		if ((encoding & 0xFE) == 0) { // CDR encoding
		}
		return 1; // 1==success
	}

	public int unmarshall_key_hash(UbiAppMsg t, ByteBuffer data, int s) {
		int offset = 0;
		data.order(ByteOrder.BIG_ENDIAN);
		return 0;
	}

	public int gen_typecode(ByteBuffer b) {
		String tc_0000 = "\n\u0000\u0000\u0000\u0036\u0000\u0000\u0000\n\u0000\u0000\u0000\u0053\u0074\u0072\u0069"
				+ "\u006e\u0067\u004d\u0073\u0067\u0000\u0000\u0000\u0001\u0000\u0000\u0000\u001e\u0000\u0000\u0000"
				+ "\u0004\u0000\u0000\u0000\u006d\u0073\u0067\u0000\u0000\u0000\u00ff\u00ff\u0000\u0000\u0000\u0000"
				+ "\r\u0000\u0000\u0000\u0006\u0000\u0000\u0000\u00ff\u00ff\u00ff\u00ff";
		byte[] tc_data = new byte[60];
		int j = 0;
		for (int i = 0; i < tc_0000.length(); i++) {
			tc_data[j++] = (byte) tc_0000.charAt(i);
		}
		if (b != null)
			b.put(tc_data, 0, 60);
		return tc_data.length;
	}

	public int get_typecode_enc() {
		return (1 & 0x01);
	}

	public int get_encoding() {
		return 0x0;
	}

	public int get_decoding() {
		return 0x0;
	}

	// key field operations
	public boolean has_key() {
		return false;
	}

	// <type> operations
	public UbiAppMsg alloc() {
		return new UbiAppMsg();
	}

	public void clear(UbiAppMsg instance) {
		instance.clear();
	}

	public void destroy(UbiAppMsg instance) { /* noop */
	}

	public void copy(UbiAppMsg to, UbiAppMsg from) {
		to.copy(from);
	}

	public boolean get_field(String fieldname, CoreDX_FieldDef fdef) {
		return false;
	}

	private long cTypeSupport = 0;
}; // StringMsg
