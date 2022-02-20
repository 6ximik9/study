using System;
using System.IO;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Kursova_Rl_
{
    public partial class FrmReg : Form
    {
        
        public static string prov;
        public static int countForm = 0;
        public FrmReg()
        {
            countForm = 1;
            InitializeComponent();
        }

        private void btnReg_Click(object sender, EventArgs e)
        {
            
                IEnumerable<string> a = (File.ReadLines("Data\\User\\User.txt"));
                int i = 0;
           
                foreach (string str in a)
                {
                    string[] l = str.Split(' ');
                    prov = l[0];
                }
        

                if (txtBoxLogin.Text == prov)
                {
                    MessageBox.Show("Такий логін вже існує, спробуйте інший");
                }
          
                else
                {
                    if (txtBoxPIB.Text == "" || txtBoxLogin.Text == "" || txtBoxPass.Text == "")
                    {
                        MessageBox.Show("Будь-ласка заповніть всі поля");
                    }
                    else
                    {
                    try
                    {
                        string text = txtBoxLogin.Text + " " + txtBoxPass.Text + Environment.NewLine;
                        File.AppendAllText("Data\\User\\User.txt", text);
                        string text1 = txtBoxLogin.Text + " " + txtBoxPIB.Text + Environment.NewLine;
                        File.AppendAllText("Data\\User\\UserPIB.txt", text1);
                        txtBoxPIB.Clear();
                        txtBoxLogin.Clear();
                        txtBoxPass.Clear();
                        Close();
                        
                        MessageBox.Show("Вітаю, ви успішно зареєструвались");
                    }
                    catch(Exception ex)
                    {
                        MessageBox.Show("Перевірте наявнысть файлу");
                    }
                    }
                
            }
            



        }
    

   
    


        private void FrmReg_FormClosing(object sender, FormClosingEventArgs e)
        {
            countForm = 0;
        }

        private void FrmReg_Load(object sender, EventArgs e)
        {
            MaximizeBox = false;
        }

        private void FrmReg_ResizeBegin(object sender, EventArgs e)
        {
            Opacity = 0.5;
        }

        private void FrmReg_ResizeEnd(object sender, EventArgs e)
        {
            Opacity = 1;
        }

        private void txtBoxLogin_TextChanged(object sender, EventArgs e)
        {

        }

        private void txtBoxLogin_KeyPress(object sender, KeyPressEventArgs e)
        {
            char number = e.KeyChar;
            if (e.KeyChar <= 192 && e.KeyChar != 8 && e.KeyChar!=47 && e.KeyChar != 48 && 
                e.KeyChar != 49 && e.KeyChar != 50 && e.KeyChar != 51 && e.KeyChar != 52 && 
                e.KeyChar != 53 && e.KeyChar != 54 && e.KeyChar != 55 && e.KeyChar != 56 & e.KeyChar != 57)
            {
                e.Handled = true;
            }
        }

        private void txtBoxPass_KeyPress(object sender, KeyPressEventArgs e)
        {
            char number = e.KeyChar;
            if (e.KeyChar <= 192 && e.KeyChar != 8 && e.KeyChar != 47 && e.KeyChar != 48 &&
                e.KeyChar != 49 && e.KeyChar != 50 && e.KeyChar != 51 && e.KeyChar != 52 &&
                e.KeyChar != 53 && e.KeyChar != 54 && e.KeyChar != 55 && e.KeyChar != 56 & e.KeyChar != 57)
            {
                e.Handled = true;
            }
        }

        private void txtBoxPIB_KeyPress(object sender, KeyPressEventArgs e)
        {
            char number = e.KeyChar;
            if (e.KeyChar <= 192 && e.KeyChar != 8 &&e.KeyChar!=32)
            {
                e.Handled = true;
            }
        }

        private void btnBack_Click(object sender, EventArgs e)
        {
            countForm = 0;
            this.Hide();
        }
    }
}
