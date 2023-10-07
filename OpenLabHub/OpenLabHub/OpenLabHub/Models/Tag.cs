using System;
using System.Collections.Generic;
using System.Text;

namespace OpenLabHub.Models
{
    public class Tag
    {
        public string name { get; set; }
        public HashSet<ProjectTag> projectTags { get; set; }
        public HashSet<ImpliedTag> impliedTags { get; set; }
        public HashSet<User> users { get; set; }
    }
    public class ImpliedTag
    {
        private Tag baseTag { get; set; }
        public Tag relatedTag { get; set; }
    }

}
