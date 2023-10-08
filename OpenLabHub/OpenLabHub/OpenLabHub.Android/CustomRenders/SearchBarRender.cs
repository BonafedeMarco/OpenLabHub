using Android.App;
using Android.Content;
using Android.Content.Res;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using static Java.Util.ResourceBundle;
using Xamarin.Forms.Platform.Android;
using Xamarin.Forms;
using OpenLabHub.CustomRenders;
using OpenLabHub.Droid.CustomRenders;

[assembly: ExportRenderer(typeof(CustomSearchBar), typeof(SearchBarRender))]

namespace OpenLabHub.Droid.CustomRenders
{
    public class SearchBarRender : SearchBarRenderer
    {
        public SearchBarRender(Context context) : base(context) { }

        protected override void OnElementChanged(ElementChangedEventArgs<SearchBar> e)
        {
            base.OnElementChanged(e);
            if (Control != null)
            {
                var plateId = Resources.GetIdentifier("android:id/search_plate", null, null);
                var plate = Control.FindViewById(plateId);
                plate.SetBackgroundColor(Android.Graphics.Color.Transparent);
                var searchView = base.Control as SearchView;
                int searchIconId = Context.Resources.GetIdentifier("android:id/search_mag_icon", null, null);
                var icon = (ImageView)searchView.FindViewById(searchIconId);
                icon.LayoutParameters = new LinearLayout.LayoutParams(0, 0);
                Control.SetPadding(0, 0, 0, 0);

                int searchViewCloseButtonId = Control.Resources.GetIdentifier("android:id/search_close_btn", null, null);
                var closeIcon = searchView.FindViewById(searchViewCloseButtonId);
                (closeIcon as ImageView).SetImageResource(Resource.Drawable.CancelIcon3);
            }
        }
    }
}