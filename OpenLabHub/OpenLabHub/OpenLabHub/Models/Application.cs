using System;
using System.Collections.Generic;
using System.Text;

namespace OpenLabHub.Models
{
    public class Application
    {
        public string state { get; set; }
        public string message { get; set; }
        public User user { get; set; }
        public Project project { get; set; }
    }
}
