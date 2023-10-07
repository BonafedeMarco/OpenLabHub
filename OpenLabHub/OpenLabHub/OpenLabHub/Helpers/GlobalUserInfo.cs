using Newtonsoft.Json;
using OpenLabHub.Models;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Text;
using Xamarin.Essentials;

namespace OpenLabHub.Helpers
{
    public static class GlobalUserInfo
    {
        public static void UpdateUserInfo(MainUserInfo user) => Preferences.Set("GlobalUserInfo", JsonConvert.SerializeObject(user));
        public static MainUserInfo GetUserInfo()
        {
            MainUserInfo user = null;
            try
            {
                var jsonUser = Preferences.Get("GlobalUserInfo", "");
                if (!string.IsNullOrEmpty(jsonUser))
                    user = JsonConvert.DeserializeObject<MainUserInfo>(jsonUser);
            }
            catch (Exception ex) { Debug.WriteLine("Error al deserializar el usuario: " + ex.Message); }

            if (user == null)
            {
                user.UserInfo = new User();
                user.MainState = MainUserState.Unlogged;
                UpdateUserInfo(user);
            }

            return user;
        }
    }
}