using OpenLabHub.Models;
using Polly;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using Xamarin.Essentials;

namespace OpenLabHub.Services
{
    public interface IUserService
    {
        //Task<BoolJsonResponse> RegisterUser(User user);
    }

    public class UserService
    {
        bool IsConnected => Connectivity.NetworkAccess == NetworkAccess.Internet;
        private CancellationTokenSource cancellationToken;
        HttpClient cliente;
        public UserService()
        {
            var httpclientHandler = new HttpClientHandler();
            httpclientHandler.ServerCertificateCustomValidationCallback = (message, cert, chain, sslPolicyErrors) => true;
            cliente = new HttpClient(httpclientHandler);
        }
        string _url = string.Empty;

        //public async Task<> RegisterLog(User user)
        //{
        //    BoolJsonResponse _response = new BoolJsonResponse();

        //    var retryPolicy = Policy.HandleResult<BoolJsonResponse>(r => r.responseServiceType != ResponseServiceType.OK).WaitAndRetryAsync(1, i => TimeSpan.FromSeconds(2), (ex, time) => { });

        //    await retryPolicy.ExecuteAsync(async () =>
        //    {
        //        try
        //        {
        //            cancellationToken = new CancellationTokenSource();
        //            cancellationToken.CancelAfter(TimeSpan.FromSeconds(5));

        //            if (!IsConnected)
        //                _response.responseServiceType = ResponseServiceType.NoConnection;
        //            else
        //            {
        //                _url = $"{AppConstants.ApisUrl}/rcvlog.php";

        //                var json = JsonConvert.SerializeObject(log);

        //                var data = new StringContent(json, Encoding.UTF8, "application/json");

        //                var response = await cliente.PostAsync(_url, data, cancellationToken.Token);

        //                if (response.IsSuccessStatusCode && response != null)
        //                {
        //                    string result = await response.Content.ReadAsStringAsync();

        //                    _response = JsonConvert.DeserializeObject<BoolJsonResponse>(result);

        //                    if (Convert.ToBoolean(_response.rta))
        //                        _response.responseBJRType = ResponseBJRType.CheckOut;
        //                    else
        //                        _response.responseBJRType = ResponseBJRType.Invalid;

        //                    _response.responseServiceType = ResponseServiceType.OK;
        //                }
        //                else
        //                    _response.responseServiceType = ResponseServiceType.ResponseFailed;
        //            }
        //        }
        //        catch (OperationCanceledException)
        //        {
        //            _response.responseServiceType = ResponseServiceType.TimeOut;
        //        }
        //        catch (Exception)
        //        {
        //            _response.responseServiceType = ResponseServiceType.ResponseFailed;
        //        }

        //        return _response;
        //    });

        //    return _response;
        //}
    }
}
