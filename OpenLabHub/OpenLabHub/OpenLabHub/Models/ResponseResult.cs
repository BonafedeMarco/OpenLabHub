using System;
using System.Collections.Generic;
using System.Text;

namespace OpenLabHub.Models
{
    public class ResponseResult
    {
        public ResponseServiceType responseServiceType { get; set; }
    }
    public enum ResponseServiceType { OK, NoConnection, ResponseFailed, TimeOut }
}
