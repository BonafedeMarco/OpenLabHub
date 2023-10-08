using Android.Content;
using Android.Graphics.Drawables;
using Xamarin.Forms.Platform.Android;
using OpenLabHub.Droid.CustomRenders;
using Xamarin.Forms;
using OpenLabHub.CustomRenders;

[assembly: ExportRenderer(typeof(CustomEntry), typeof(EntryRender))]

namespace OpenLabHub.Droid.CustomRenders
{
    public class EntryRender : EntryRenderer
    {
        public EntryRender(Context context) : base(context)
        {
            AutoPackage = false;
        }
        protected override void OnElementChanged(ElementChangedEventArgs<Entry> e)
        {
            base.OnElementChanged(e);
            if (Control != null)
            {
                Control.Background = new ColorDrawable(Android.Graphics.Color.Transparent);
            }
        }
    }
}